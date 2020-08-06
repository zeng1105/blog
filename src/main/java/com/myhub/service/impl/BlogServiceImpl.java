package com.myhub.service.impl;

import com.myhub.entity.Blog;
import com.myhub.mapper.BlogMapper;
import com.myhub.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zeng1105
 * @since 2020-08-06
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
