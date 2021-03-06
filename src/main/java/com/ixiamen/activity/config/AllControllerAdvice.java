package com.ixiamen.activity.config;

import com.ixiamen.activity.base.BusinessException;
import com.ixiamen.activity.base.PublicResultConstant;
import com.ixiamen.activity.exception.ParamJsonException;
import com.ixiamen.activity.exception.UnauthorizedException;
import org.apache.shiro.ShiroException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.exceptions.TemplateInputException;

/**
 * Controller统一异常处理
 *
 * @author : luoyongbin
 * @date : 2018/05/08
 */
@ControllerAdvice
public class AllControllerAdvice {
    private static final Logger logger = LoggerFactory.getLogger(AllControllerAdvice.class);

    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
    }

    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     */
    @ModelAttribute
    public void addAttributes(Model model) {
    }

    /**
     * 全局异常捕捉处理
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseModel<String> errorHandler(Exception ex) {
        ex.printStackTrace();
        logger.error("接口出现严重异常：{}", ex.getMessage());
        return ResponseHelper.validationFailure(PublicResultConstant.FAILED);
    }

    /**
     * 捕捉UnauthorizedException
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    public ResponseModel<String> handleUnauthorized() {
        return ResponseHelper.validationFailure(PublicResultConstant.USER_NO_PERMITION);
    }

    /**
     * 捕捉shiro的异常
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(ShiroException.class)
    @ResponseBody
    public ResponseModel<String> handleShiroException(ShiroException e) {
        return ResponseHelper.validationFailure(PublicResultConstant.USER_NO_PERMITION);
    }

    /**
     * 捕捉BusinessException自定义抛出的异常
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public ResponseModel handleBusinessException(BusinessException e) {
        if (e != null) {
            logger.info(PublicResultConstant.BUSINESSEXCEPTION_ERROR + e.getMessage());
            return ResponseHelper.validationFailure(PublicResultConstant.BUSINESSEXCEPTION_ERROR + e.getMessage());
        }
        return ResponseHelper.validationFailure(PublicResultConstant.ERROR);
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(TemplateInputException.class)
    @ResponseBody
    public ResponseModel<String> handleTemplateInputException(TemplateInputException e) {
        return ResponseHelper.validationFailure(PublicResultConstant.USER_NO_PERMITION);
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(value = ParamJsonException.class)
    @ResponseBody
    public ResponseModel<String> handleParamJsonException(Exception e) {
        if (e instanceof ParamJsonException) {
            logger.info("参数错误：" + e.getMessage());
            return ResponseHelper.validationFailure("参数错误：" + e.getMessage());
        }
        return ResponseHelper.validationFailure(PublicResultConstant.ERROR);
    }


}