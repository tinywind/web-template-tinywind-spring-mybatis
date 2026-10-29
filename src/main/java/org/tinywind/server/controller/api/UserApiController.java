package org.tinywind.server.controller.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.tinywind.server.model.UserEntity;
import org.tinywind.server.model.form.LoginForm;
import org.tinywind.server.repository.UserRepository;
import org.tinywind.server.util.JsonResult;

import jakarta.validation.Valid;

/**
 * @author tinywind
 */
@Tag(name = "USER", description = "사용자 정보")
@RestController
@RequestMapping(value = "api/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserApiController extends ApiBaseController {
    private static final Logger logger = LoggerFactory.getLogger(UserApiController.class);

    @Autowired
    private UserRepository userRepository;

    @Operation(summary = "로그인")
    @PostMapping("login")
    public JsonResult login(@RequestBody @Valid LoginForm form, BindingResult bindingResult) {
        if (!form.validate(bindingResult))
            return JsonResult.create(bindingResult);

        if (userRepository.findOneById(form.getId()) == null)
            return JsonResult.create("존재하지 않는 사용자 ID 입니다.");

        final UserEntity user = userRepository.findOneByIdAndPassword(form);
        if (user == null)
            return JsonResult.create("일치하지 않는 비밀번호입니다.");

        g.invalidateSession();
        g.setCurrentUser(user);

        return JsonResult.create();
    }

    @Operation(summary = "로그아웃")
    @PostMapping("logout")
    public JsonResult logout() {
        g.invalidateSession();
        return JsonResult.create();
    }
}
