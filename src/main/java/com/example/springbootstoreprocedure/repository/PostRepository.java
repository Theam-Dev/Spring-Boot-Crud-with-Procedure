package com.example.springbootstoreprocedure.repository;

import com.example.springbootstoreprocedure.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query(value = "{call post_sp(:cmd)}", nativeQuery = true)
    List<Post> getAll(@Param("cmd") String cmd);
    @Transactional
    @Modifying
    @Query(value = "{call post_sp(:cmd,NULL,:title,:body)}", nativeQuery = true)
    void savePost(
            @Param("cmd") String cmd,
            @Param("title") String title,
            @Param("body") String body
    );
    @Transactional
    @Modifying
    @Query(value = "{call post_sp(:cmd,:id, :title, :body)}", nativeQuery = true)
    void updatePost(
            @Param("cmd") String cmd,
            @Param("id") Long id,
            @Param("title") String title,
            @Param("body") String body
    );
    @Query(value = "{call post_sp(:cmd, :id)}", nativeQuery = true)
    Post editPost(
            @Param("cmd")String cmd,
            @Param("id") Long id
    );
    @Transactional
    @Modifying
    @Query(value = "{call post_sp(:cmd, :id)}", nativeQuery = true)
    void deletePost(
            @Param("cmd") String cmd,
            @Param("id") Long id
    );
}