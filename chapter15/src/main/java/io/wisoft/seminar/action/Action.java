package io.wisoft.seminar.action;

import io.wisoft.seminar.vo.ActionForward;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Action {

  ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;



}
