package com.yph.mapper;

import org.apache.ibatis.annotations.Select;

public interface MemberMapper {

    @Select("select 'member'")
    String selectByMemberId();

}
