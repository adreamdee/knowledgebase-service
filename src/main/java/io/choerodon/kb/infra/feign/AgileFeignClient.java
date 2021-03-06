package io.choerodon.kb.infra.feign;

import java.util.List;

import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.choerodon.kb.api.vo.ProjectDTO;
import io.choerodon.kb.infra.feign.fallback.BaseFeignClientFallback;

/**
 * Created by 25499 on 20120/1/17.
 */
@FeignClient(value = "agile-service", fallback = BaseFeignClientFallback.class)
public interface AgileFeignClient {

    @DeleteMapping(value = "/v1/projects/{project_id}/knowledge_relation/delete/{space_id}")
    ResponseEntity<List<ProjectDTO>> deleteByworkSpaceId(@ApiParam(value = "项目id", required = true)
                                                         @PathVariable(name = "project_id") Long projectId,
                                                         @ApiParam(value = "workSpaceId", required = true)
                                                         @PathVariable(name = "space_id") Long spaceId);
}

