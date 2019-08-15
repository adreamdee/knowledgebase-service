import React, { useContext } from 'react';
import { observer } from 'mobx-react-lite';
import { withRouter } from 'react-router-dom';
import { stores } from '@choerodon/master';
import PageStore from '../../../stores';
import DocViewer from '../../../../../components/DocViewer';

const { AppState } = stores;

function ViewMode(props) {
  const { readOnly, loadWorkSpace } = props;
  const { pageStore } = useContext(PageStore);
  const { getWorkSpace: workSpace, getSpaceCode: spaceCode } = pageStore;
  const { getMode: mode, getDoc: data } = pageStore;

  return (
    <span>
      <DocViewer
        readOnly={readOnly}
        spaceData={workSpace[spaceCode].data}
        data={data}
        loginUserId={AppState.userInfo.id}
        store={pageStore}
        onBreadcrumbClick={loadWorkSpace}
      />
    </span>
  );
}

export default observer(ViewMode);
