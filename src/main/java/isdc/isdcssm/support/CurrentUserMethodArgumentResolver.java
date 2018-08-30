package isdc.isdcssm.support;


import isdc.isdcssm.dao.UserDAO;
import isdc.isdcssm.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

@Component
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private UserDAO userDAO;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(User.class) &&
                parameter.hasParameterAnnotation(CurrentUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Integer currentUserId = (Integer) webRequest.getAttribute(Constants.HEADER_USER_ID, RequestAttributes.SCOPE_REQUEST);
        if (currentUserId != null) {
            System.out.println("有");
            User one = userDAO.selectByPrimaryKey(currentUserId);
            if (one != null) {
                return one;
            }
        }
        System.out.println("没有");
        throw new MissingServletRequestPartException(Constants.HEADER_USER_ID);
    }
}
