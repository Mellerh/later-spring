package ru.practicum.itemNote;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import ru.practicum.item.Item;

import java.time.Instant;

@Entity
@Table(name = "item_notes")
@Data
@Builder
public class ItemNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @Column(name = "text")
    private String text;

    @Column(name = "registration_date")
    private Instant registrationDate = Instant.now();

}

