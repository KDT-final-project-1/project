package com.pixcel.app.codevalue.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pixcel.app.codevalue.service.CodeValueService;
import com.pixcel.app.codevalue.service.CodeValueVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
//@RequestMapping("/code-values")
public class CodeValueController {

    private final CodeValueService codeValueService;

    // 코드값 목록 화면
    @GetMapping
    public String list(@RequestParam String userId, Model model) {
        model.addAttribute("codeValueList", codeValueService.getCodeValueList(userId));
        return "codeValue/list";
    }

    // 특정 그룹의 코드값 목록 화면
    @GetMapping("/code-values/group")
    public String listByGroup(
            @RequestParam String userId,
            @RequestParam String groupName,
            Model model
    ) {
        model.addAttribute("codeValueList", codeValueService.getCodeValueListByGroup(userId, groupName));
        model.addAttribute("groupName", groupName);
        return "codeValue/list";
    }

    // 코드값 등록 화면
    @GetMapping("/code-values/new")
    public String createForm(Model model) {
        model.addAttribute("codeValue", new CodeValueVO());
        return "codeValue/form";
    }

    // 코드값 등록 처리
    @PostMapping("/code-values/new")
    public String create(CodeValueVO codeValue) {
        codeValueService.createCodeValue(codeValue);
        return "redirect:/code-values?userId=" + codeValue.getUserId();
    }

    // 코드값 수정 화면
    @GetMapping("/code-values/edit")
    public String editForm(@RequestParam Integer settingCodeId, Model model) {
        model.addAttribute("codeValue", codeValueService.getCodeValueDetail(settingCodeId));
        return "codeValue/form";
    }

    // 코드값 수정 처리
    @PostMapping("/code-values/edit")
    public String edit(CodeValueVO codeValue) {
        codeValueService.modifyCodeValue(codeValue);
        return "redirect:/code-values?userId=" + codeValue.getUserId();
    }

    // 코드값 삭제 처리
    @PostMapping("/code-values/delete")
    public String delete(
            @RequestParam Integer settingCodeId,
            @RequestParam String userId
    ) {
        codeValueService.removeCodeValue(settingCodeId);
        return "redirect:/code-values?userId=" + userId;
    }
}