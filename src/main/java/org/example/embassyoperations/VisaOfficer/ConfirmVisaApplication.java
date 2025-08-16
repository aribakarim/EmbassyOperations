package org.example.embassyoperations;

import java.time.LocalDate;

public class ConfirmVisaApplication {
    private LocalDate InterviewSchedule;

    public LocalDate getInterviewSchedule() {
        return InterviewSchedule;
    }

    @Override
    public String toString() {
        return "ConfirmVisaApplication{" +
                "InterviewSchedule=" + InterviewSchedule +
                '}';
    }

    public void setInterviewSchedule(LocalDate interviewSchedule) {
        InterviewSchedule = interviewSchedule;
    }

    public ConfirmVisaApplication(LocalDate interviewSchedule) {
        InterviewSchedule = interviewSchedule;
    }
}
