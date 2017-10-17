/*
 * Copyright 2017 Huawei Technologies Co., Ltd.
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

package org.onap.cli.fw.http.mock;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.onap.cli.fw.error.OnapCommandFailedMocoGenerate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

public class MockRequest {
    private String method;
    private String uri;
    private Map<String, String> headers;
    private JsonNode json;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String url) throws OnapCommandFailedMocoGenerate {
        URL urlt;
        try {
            urlt = new URL(url);
        } catch (MalformedURLException error) {
            throw new OnapCommandFailedMocoGenerate(null, error);
        }
        this.uri = urlt.getPath();
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public JsonNode getJson() {
        return json;
    }

    public void setJson(String json) throws OnapCommandFailedMocoGenerate {
        if (json.isEmpty()) {
            this.json = JsonNodeFactory.instance.objectNode();
            return;
        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.json = objectMapper.readTree(json);
        }catch (IOException error) {
            throw new OnapCommandFailedMocoGenerate(null, error);
        }
    }
}
