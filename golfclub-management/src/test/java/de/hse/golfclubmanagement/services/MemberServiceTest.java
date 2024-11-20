package de.hse.golfclubmanagement.services;

import de.hse.golfclubmanagement.models.Member;
import de.hse.golfclubmanagement.repositories.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class MemberServiceTest {

    @InjectMocks
    private MemberService memberService;

    @Mock
    private MemberRepository memberRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testaddMember() {
        // Arrange:
        Member mockMember = new Member();
        mockMember.setName("Max Mustermann");
        when(memberRepository.save(any(Member.class))).thenReturn(mockMember);

        // Act:
        Member result = memberService.addMember(mockMember);

        // Assert:
        assertNotNull(result);
        assertEquals("Max Mustermann", result.getName());
        verify(memberRepository, times(1)).save(mockMember);
    }

    @Test
    void testgetAllMembers() {
        // Arrange:
        List<Member> mockMembers = new ArrayList<>();
        mockMembers.add(new Member());
        mockMembers.add(new Member());
        when(memberRepository.findAll()).thenReturn(mockMembers);

        // Act:
        List<Member> result = memberService.getAllMembers();

        // Assert:
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(memberRepository, times(1)).findAll();
    }

    @Test
    void testfindByName_true() {
        // Arrange:
        String name = "Max Mustermann";
        Member mockMember = new Member();
        mockMember.setName(name);
        when(memberRepository.findByName(name)).thenReturn(mockMember);

        // Act:
        Member result = memberService.findByName(name);

        // Assert:
        assertNotNull(result);
        assertEquals(name, result.getName());
        verify(memberRepository, times(1)).findByName(name);
    }

    @Test
    void testfindByName_false() {
        // Arrange:
        String name = "Max Mustermann";
        when(memberRepository.findByName(name)).thenReturn(null); // Kein Treffer

        // Act:
        Member result = memberService.findByName(name);

        // Assert:
        assertNull(result); // Ergebnis sollte null sein
        verify(memberRepository, times(1)).findByName(name);
    }
}