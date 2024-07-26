/*
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
package com.facebook.presto.plugin.oracle;

import com.facebook.airlift.configuration.Config;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import java.math.RoundingMode;

public class OracleConfig
{
    private boolean synonymsEnabled;
    private int varcharMaxSize = 4000;
    private int timestampDefaultPrecision = 6;
    private int numberDefaultScale = 10;
    private RoundingMode numberRoundingMode = RoundingMode.HALF_UP;
    private boolean tlsEnabled;
    private String keystorePath;
    private String trustStorePath;
    private String keystorePassword;
    private String truststorePassword;

    @NotNull
    public boolean isSynonymsEnabled()
    {
        return synonymsEnabled;
    }

    @Config("oracle.synonyms.enabled")
    public OracleConfig setSynonymsEnabled(boolean enabled)
    {
        this.synonymsEnabled = enabled;
        return this;
    }

    @Min(0)
    @Max(38)
    public int getNumberDefaultScale()
    {
        return numberDefaultScale;
    }

    @Config("oracle.number.default-scale")
    public OracleConfig setNumberDefaultScale(int numberDefaultScale)
    {
        this.numberDefaultScale = numberDefaultScale;
        return this;
    }

    @NotNull
    public RoundingMode getNumberRoundingMode()
    {
        return numberRoundingMode;
    }

    @Config("oracle.number.rounding-mode")
    public OracleConfig setNumberRoundingMode(RoundingMode numberRoundingMode)
    {
        this.numberRoundingMode = numberRoundingMode;
        return this;
    }

    @Min(4000)
    public int getVarcharMaxSize()
    {
        return varcharMaxSize;
    }

    @Config("oracle.varchar.max-size")
    public OracleConfig setVarcharMaxSize(int varcharMaxSize)
    {
        this.varcharMaxSize = varcharMaxSize;
        return this;
    }

    @Min(0)
    @Max(9)
    public int getTimestampDefaultPrecision()
    {
        return timestampDefaultPrecision;
    }

    @Config("oracle.timestamp.precision")
    public OracleConfig setTimestampDefaultPrecision(int timestampDefaultPrecision)
    {
        this.timestampDefaultPrecision = timestampDefaultPrecision;
        return this;
    }

    public boolean isTlsEnabled()
    {
        return tlsEnabled;
    }

    @Config("oracle.tls.enabled")
    public OracleConfig setTlsEnabled(boolean tlsEnabled)
    {
        this.tlsEnabled = tlsEnabled;
        return this;
    }

    public String getKeystorePath()
    {
        return keystorePath;
    }

    @Config("oracle.tls.keystore-path")
    public OracleConfig setKeystorePath(String path)
    {
        this.keystorePath = path;
        return this;
    }

    public String getTrustStorePath()
    {
        return trustStorePath;
    }

    @Config("oracle.tls.truststore-path")
    public OracleConfig setTrustStorePath(String path)
    {
        this.trustStorePath = path;
        return this;
    }

    public String getKeystorePassword()
    {
        return keystorePassword;
    }

    @Config("oracle.tls.keystore-password")
    public OracleConfig setKeystorePassword(String password)
    {
        this.keystorePassword = password;
        return this;
    }

    public String getTruststorePassword()
    {
        return truststorePassword;
    }

    @Config("oracle.tls.truststore-password")
    public OracleConfig setTruststorePassword(String password)
    {
        this.truststorePassword = password;
        return this;
    }
}
