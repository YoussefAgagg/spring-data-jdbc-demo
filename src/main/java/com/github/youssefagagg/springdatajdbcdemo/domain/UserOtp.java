package com.github.youssefagagg.springdatajdbcdemo.domain;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;
import java.util.Set;

@Table("user_otp")
@Builder
public final class UserOtp extends AbstractAuditingEntity{
    @Id
    private final Long id;
    private final String otp;
    @Column("user_id")
    private final AggregateReference<User, Long> user;

    public UserOtp(Long id,
                   String otp,
                   AggregateReference<User, Long> user) {
        this.id = id;
        this.otp = otp;
        this.user = user;
    }

    @Id
    public Long id() {
        return id;
    }

    public String otp() {
        return otp;
    }

    @Column("user_id")
    public AggregateReference<User, Long> user() {
        return user;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (UserOtp) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.otp, that.otp) &&
                Objects.equals(this.user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, otp, user);
    }

    @Override
    public String toString() {
        return "UserOtp[" +
                "id=" + id + ", " +
                "otp=" + otp + ", " +
                "user=" + user + ']';
    }


}
