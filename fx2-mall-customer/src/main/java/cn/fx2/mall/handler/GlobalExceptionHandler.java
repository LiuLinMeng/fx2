package cn.fx2.mall.handler;
import cn.fx2.common.utils.JsonResponseUtils;
import cn.fx2.common.utils.StatusCodeUtils;
import cn.fx2.common.utils.log.Fx2Log;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;


// 全局异常处理器
@RestControllerAdvice
public class GlobalExceptionHandler {
	private final Fx2Log log = new Fx2Log(GlobalExceptionHandler.class);

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public Object MethodArgumentNotValidHandler(MethodArgumentNotValidException exception) {
		Map<String, Object>map=new HashMap<>();
		for (FieldError error : exception.getBindingResult().getFieldErrors()) {
			map.put(error.getField(), error.getDefaultMessage());
		}
		log.error(getE(exception));
		return JsonResponseUtils.error("请求参数异常",map);
	}

	@ExceptionHandler(value = BindException.class)
	public Object BindExceptionHandler(BindException exception) {
		log.error(getE(exception));
		return JsonResponseUtils.error(StatusCodeUtils.PARAMS_NULL.getCode(),exception.getBindingResult().getFieldErrors().get(0).getDefaultMessage());
	}

	@ExceptionHandler(value = NullPointerException.class)
	public Object NullExceptionHandler(NullPointerException e) {
		log.error(getE(e));
		return JsonResponseUtils.error("请求参数异常");
	}

//	@ExceptionHandler(value = BusinessException.class)
//	public Object BusinessException(BusinessException e) {
//		log959.error(getE(e));
//		return R.error(e.getCode(),e.getMessage());
//	}

	@ExceptionHandler(value=Exception.class)
	public JsonResponseUtils defaultExceptionHandler(HttpServletRequest request, Exception e) {
		if(e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
			log.error(getE(e));

			return JsonResponseUtils.error(404, "请求路径错误");
		}else {
			log.error(getE(e));
			return JsonResponseUtils.error(e.toString());
		}
	}
	private String getE(Throwable e){
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		e.printStackTrace(new PrintStream(baos));
		System.err.println("饭小二开放平台报错 " + baos);
		return baos.toString();
	}

}
