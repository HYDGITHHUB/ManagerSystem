//package com.study.backend.search.controller;
//
//import com.study.backend.search.entity.Research;
//import com.study.backend.search.entity.ResearchRequest;
//import com.study.backend.search.repository.ResearchRepository;
//import com.study.backend.search.service.ResearchService;
//import com.study.backend.util.PageResult;
//import org.elasticsearch.action.search.SearchRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//
//@RestController
//@RequestMapping("/research")
//public class ResearchHandler {
//
//    @Autowired
//    private ResearchRepository researchRepository;
//
//    @Autowired
//    private ResearchService researchService;
//
//    /**
//     * 搜索功能
//     * @param request
//     * @return
//     */
//    @GetMapping("search")
//    public ResponseEntity<PageResult<Research>> search(ResearchRequest request) {
//        return ResponseEntity.ok(researchService.search(request));
//    }
//
//
////    @PostMapping("/find")
////    public List<Research> list() {
////        return '';
////    }
//
////    @RequestMapping("/find")
////    public List<Research> list(@RequestParam(value = "project_owner", required = false) String project_owner,
////                               @RequestParam(value = "project_theme", required = false) String project_theme,
////                               @RequestParam(value = "project_type", required = false) String project_type,
////                               @RequestParam(value = "project_grade", required = false) String project_grade,
////                               @RequestParam(value = "pageIndex", defaultValue = "0") int pageIndex,
////                               @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
////        Pageable pageable = PageRequest.of(pageIndex, pageSize);
////        Page<Research> page = researchRepository.findDistinctByProject_ownerOrProject_themeOrProject_typeOrProject_grade(project_owner, project_theme,project_type,project_grade, pageable);
////        return page.getContent();
////    }
//
//}
//
