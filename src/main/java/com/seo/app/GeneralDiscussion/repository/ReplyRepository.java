package com.seo.app.GeneralDiscussion.repository;

import com.seo.app.GeneralDiscussion.domain.ReplyDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepository extends JpaRepository<ReplyDomain,Integer> {
    ReplyDomain findByReplyTo(int replyTo);
}
