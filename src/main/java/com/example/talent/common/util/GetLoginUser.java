package com.example.talent.common.util;

import com.example.talent.common.dto.LoginUserDTO;
import com.example.talent.common.exception.InvalidSessionException;
import jakarta.servlet.http.HttpSession;

public class GetLoginUser {

    public static LoginUserDTO getLoginUserDTO(HttpSession session) {
        if (session.getAttribute("loginUserDTO") == null) {
            throw new InvalidSessionException();
        }
        return (LoginUserDTO) session.getAttribute("loginUserDTO");
    }

}
