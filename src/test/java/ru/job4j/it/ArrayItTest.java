package ru.job4j.it;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class ArrayItTest {

    @Test
    public void whenMultiCallhasNextThenTrue() {
        ArrayIt it = new ArrayIt(new int[]{1, 2, 3});
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
    }

    @Test
    public void whenReadSequence() {
        ArrayIt it = new ArrayIt(new int[]{1, 2, 3});
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
    }

    @Test
    public void whenReadBack() {
        ArrayIt it = new ArrayIt(new int[]{1, 2, 3});
        assertThat(it.previus(), is(3));
        assertThat(it.previus(), is(2));
        assertThat(it.previus(), is(1));
    }

    @Test
    public void hwenMultiCallhasPreviusThenTrue() {
        ArrayIt it = new ArrayIt(new int[]{1, 2, 3});
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
    }


}