package com.john.job_connect.repository;

import com.john.job_connect.model.Post;


import java.util.List;

public interface SearchRepository {
   List<Post> findByText(String text);


}
