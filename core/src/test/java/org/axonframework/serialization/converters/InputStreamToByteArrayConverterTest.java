/*
 * Copyright (c) 2010-2012. Axon Framework
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.axonframework.serialization.converters;

import org.axonframework.serialization.SerializedObject;
import org.axonframework.serialization.SimpleSerializedObject;
import org.axonframework.serialization.SimpleSerializedType;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * @author Allard Buijze
 */
public class InputStreamToByteArrayConverterTest {

    private InputStreamToByteArrayConverter testSubject;
    private SimpleSerializedType type;

    @Before
    public void setUp() throws Exception {
        testSubject = new InputStreamToByteArrayConverter();
        type = new SimpleSerializedType("bla", "0");
    }

    @Test
    public void testConvert() {
        byte[] bytes = "Hello, world!".getBytes();
        InputStream inputStream = new ByteArrayInputStream(bytes);
        SerializedObject<byte[]> actual = testSubject
                .convert(new SimpleSerializedObject<>(inputStream, InputStream.class, type));

        assertEquals(type, actual.getType());
        assertArrayEquals(bytes, actual.getData());
    }
}
