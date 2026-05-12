package ru.mentee.power.devtools.progress;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Testing ProgressTracker")
class ProgressLoopTest {

  @Test
  @DisplayName("Must correctly calculate the total progress when an array of mentee is passed")
  void shouldCalculateTotalProgressWhenMultipleMentees() {
    // given - подготовка данных
    ProgressTracker tracker = new ProgressTracker();
    Mentee[] mentees = {
        new Mentee("Иван", "Москва", "Backend разработка", 5, 12),
        new Mentee("Мария", "Санкт-Петербург", "Fullstack", 8, 12),
        new Mentee("Пётр", "Казань", "Java Backend", 12, 12)
    };

    // when - выполнение действия
    String result = tracker.calculateTotalProgress(mentees);

    // then - проверка результата с assertJ
    assertThat(result)
        .contains("Total finished 25 from 36 lessons")
        .contains("left 11 lessons");
  }

  @Test
  @DisplayName("Should handle the array correctly when all mentee have completed the course")
  void shouldCalculateTotalProgressWhenAllMenteesCompleted() {
    // given
    ProgressTracker tracker = new ProgressTracker();
    Mentee[] mentees = {
        new Mentee("Иван", "Москва", "Backend", 12, 12),
        new Mentee("Мария", "СПб", "Fullstack", 12, 12)
    };

    // when
    String result = tracker.calculateTotalProgress(mentees);

    // then
    assertThat(result)
        .contains("Total finished 24 from 24 lessons")
        .contains("left 0 lessons");
  }

  @Test
  @DisplayName("Should check array is empty")
  void shouldCheckArrayIsEmptyWhenMethodStarted() {
    // given
    ProgressTracker tracker = new ProgressTracker();
    Mentee[] mentees = {};

    // when
    String result = tracker.calculateTotalProgress(mentees);

    // then
    assertThat(result)
        .contains("Array is empty or NULL");
  }

  @Test
  @DisplayName("Should not throw exception when creating Mentee with valid data")
  void shouldNotThrowExceptionWhenCreatingValidMentee() {
    assertThatCode(() -> new Mentee("Иван", "Москва", "Backend", 12, 12))
        .doesNotThrowAnyException();
  }

  @Test
  @DisplayName("Should throw IllegalArgumentException when creating Mentee with invalid progress")
  void shouldThrowIllegalArgumentExceptionWhenCreatingInvalidMentee() {

    assertThatThrownBy(() ->
        new Mentee("Мария", "СПб", "Fullstack", 25, 12)
    )
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("Некорректные значения прогресса");
  }
}
