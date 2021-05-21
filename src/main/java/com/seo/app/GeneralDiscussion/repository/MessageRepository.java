package com.seo.app.GeneralDiscussion.repository;

import com.seo.app.GeneralDiscussion.domain.AdminMessageDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<AdminMessageDomain,Integer> {
}
