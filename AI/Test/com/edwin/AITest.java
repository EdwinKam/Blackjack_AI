package com.edwin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AITest {

    @Test
    void main() {
        Player p = new Player(1,10);
        p.addCard(2);
        p.addCard(2);
        p.split();
        p.clearHands();
        System.out.println(p);
    }
}