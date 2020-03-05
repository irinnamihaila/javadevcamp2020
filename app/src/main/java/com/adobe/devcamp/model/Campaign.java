package com.adobe.devcamp.model;

import com.sun.tools.javac.jvm.Gen;

import java.lang.annotation.Target;
import java.util.List;
import java.util.Objects;

public final class Campaign {
    private final String name;
    private final Long startTime;
    private final Long endTime;
    private final Target target;
    private final Integer advertiserId;

    public Campaign(String name, Long startTime, Long endTime, Target target, Integer advertiserId) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.target = target;
        this.advertiserId = advertiserId;
    }

    public String getName() {
        return name;
    }

    public Long getStartTime() {
        return startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public Target getTarget() {
        return target;
    }

    public Integer getAdvertiserId() {
        return advertiserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Campaign campaign = (Campaign) o;
        return Objects.equals(name, campaign.name) &&
                Objects.equals(startTime, campaign.startTime) &&
                Objects.equals(endTime, campaign.endTime) &&
                Objects.equals(target, campaign.target) &&
                Objects.equals(advertiserId, campaign.advertiserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, startTime, endTime, target, advertiserId);
    }

    @Override
    public String toString() {
        return "Campaign{" +
                "name='" + name + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", target=" + target +
                ", advertiserId=" + advertiserId +
                '}';
    }

    public static final class Target {
        private final Gender gender;
        private final List<Domain> interests;
        private final short minAge;
        private final short maxAge;

        public Target(Gender gender, List<Domain> interests, short minAge, short maxAge) {
            this.gender = gender;
            this.interests = interests;
            this.minAge = minAge;
            this.maxAge = maxAge;
        }

        public Gender getGender() {
            return gender;
        }

        public List<Domain> getInterests() {
            return interests;
        }

        public short getMinAge() {
            return minAge;
        }

        public short getMaxAge() {
            return maxAge;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Target target = (Target) o;
            return minAge == target.minAge &&
                    maxAge == target.maxAge &&
                    gender == target.gender &&
                    Objects.equals(interests, target.interests);
        }

        @Override
        public int hashCode() {
            return Objects.hash(gender, interests, minAge, maxAge);
        }

        @Override
        public String toString() {
            return "Target{" +
                    "gender=" + gender +
                    ", interests=" + interests +
                    ", minAge=" + minAge +
                    ", maxAge=" + maxAge +
                    '}';
        }
    }
}
