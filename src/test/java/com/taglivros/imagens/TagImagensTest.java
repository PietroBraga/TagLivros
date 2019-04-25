package com.taglivros.imagens;

import org.eclipse.jetty.util.thread.strategy.ExecuteProduceConsume;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TagImagensTest {
    @Test
    public void obtemLinkkDasImages() throws Exception {
        List<String> result = TagImagens.obtemLinkDasImagens();
        Assert.assertTrue(!result.isEmpty());
    }
}