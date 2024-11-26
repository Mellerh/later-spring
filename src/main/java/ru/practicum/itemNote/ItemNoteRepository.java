package ru.practicum.itemNote;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemNoteRepository extends JpaRepository<ItemNote, Long> {

    List<ItemNote> findAllByItemUrlContainingAndItemUserId(String url, Long userId);

    @Query("select iNote " +
            "from ItemNote as iNote " +
            "join fetch iNote.item as item " +
            "where ?1 member of item.tags " +
            "and where item.userId = ?2")
    List<ItemNote> getItemNotesByTag(String tag, Long userId);

    List<ItemNote> findAllByUserId(Long userId, PageRequest pageRequest);
}

