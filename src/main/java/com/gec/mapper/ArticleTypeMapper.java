package com.gec.mapper;

import com.gec.pojo.ArticleType;
import com.gec.pojo.ArticleTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleTypeMapper {
    int countByExample(ArticleTypeExample example);

    int deleteByExample(ArticleTypeExample example);

    int deleteByPrimaryKey(String code);

    int insert(ArticleType record);

    int insertSelective(ArticleType record);

    List<ArticleType> selectByExample(ArticleTypeExample example);

    ArticleType selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") ArticleType record, @Param("example") ArticleTypeExample example);

    int updateByExample(@Param("record") ArticleType record, @Param("example") ArticleTypeExample example);

    int updateByPrimaryKeySelective(ArticleType record);

    int updateByPrimaryKey(ArticleType record);

    /**
     * 查询二级分类
     *     写sql注意事项
     *   <select id="findSecondArticleTypes" resultMap="BaseResultMap">
     *      select * from ec_article_type where code like "________"
     *   </select>
     *   <mapper namespace="com.gec.mapper.ArticleTypeMapper">
     *      com.gec.mapper.ArticleTypeMapperr
     *   namespace的值和接口的全路径名称保持一致
     *   id和接口方法名称保持一致
     *   parameterType的值和方法的入参类型保持一致
     *   resultType和方法返回值保存一致
     *   @return
     */

    List<ArticleType> findSecondArticleTypes(String typecode);
}