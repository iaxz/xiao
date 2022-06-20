package plus.axz.user.filter;

import org.springframework.core.annotation.Order;
import org.springframework.web.filter.GenericFilterBean;
import plus.axz.model.user.pojos.User;
import plus.axz.utils.threadlocal.AppThreadLocalUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Order(1)/*范围小，越先执行*/
@WebFilter(filterName = "appTokenFilter", urlPatterns = "/*")/*/ 拦截所有请求*/
public class AppTokenFilter extends GenericFilterBean {/*该类需要生效，需要在启动类添加注解*/
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //得到header中的信息
        String userId = request.getHeader("userId");
        if (userId != null && Integer.valueOf(userId).intValue() != 0) {
            //装入线程中,,,详情见 AppThreadLocalUtils
            User user = new User();
            user.setId(Integer.valueOf(userId));
            AppThreadLocalUtils.setUser(user);
        }
        filterChain.doFilter(request, response);
    }
}
