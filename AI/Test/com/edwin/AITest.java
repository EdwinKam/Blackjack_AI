package com.edwin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AITest {

    @Test
    void main() {
        Hand hand = new Hand();
        hand.append(1);
        hand.append(2);
        System.out.println(hand);
    }
}