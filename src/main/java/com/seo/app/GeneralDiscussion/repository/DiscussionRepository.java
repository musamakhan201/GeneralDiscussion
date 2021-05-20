package com.seo.app.GeneralDiscussion.repository;

import com.seo.app.GeneralDiscussion.domain.DiscussionDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscussionRepository extends JpaRepository<DiscussionDomain,Integer> {
}
