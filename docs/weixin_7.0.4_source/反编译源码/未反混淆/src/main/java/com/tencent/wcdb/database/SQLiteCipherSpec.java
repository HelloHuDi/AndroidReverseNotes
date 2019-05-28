package com.tencent.wcdb.database;

import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SQLiteCipherSpec {
    public static final int HMAC_DEFAULT = -1;
    public static final int HMAC_SHA1 = 0;
    public static final int HMAC_SHA256 = 1;
    public static final int HMAC_SHA512 = 2;
    public int hmacAlgorithm = -1;
    public boolean hmacEnabled = true;
    public int kdfAlgorithm = -1;
    public int kdfIteration;
    public int pageSize = SQLiteGlobal.defaultPageSize;

    public SQLiteCipherSpec(SQLiteCipherSpec sQLiteCipherSpec) {
        this.kdfIteration = sQLiteCipherSpec.kdfIteration;
        this.hmacEnabled = sQLiteCipherSpec.hmacEnabled;
        this.pageSize = sQLiteCipherSpec.pageSize;
    }

    public SQLiteCipherSpec setKDFIteration(int i) {
        this.kdfIteration = i;
        return this;
    }

    public SQLiteCipherSpec withHMACEnabled(boolean z) {
        this.hmacEnabled = z;
        return this;
    }

    public SQLiteCipherSpec setHmacAlgorithm(int i) {
        this.hmacAlgorithm = i;
        return this;
    }

    public SQLiteCipherSpec setKdfAlgorithm(int i) {
        this.kdfAlgorithm = i;
        return this;
    }

    public SQLiteCipherSpec setPageSize(int i) {
        this.pageSize = i;
        return this;
    }

    public SQLiteCipherSpec setSQLCipherVersion(int i) {
        AppMethodBeat.i(12270);
        switch (i) {
            case 1:
                this.hmacEnabled = false;
                this.kdfIteration = WearableStatusCodes.TARGET_NODE_NOT_CONNECTED;
                this.hmacAlgorithm = 0;
                this.kdfAlgorithm = 0;
                break;
            case 2:
                this.hmacEnabled = true;
                this.kdfIteration = WearableStatusCodes.TARGET_NODE_NOT_CONNECTED;
                this.hmacAlgorithm = 0;
                this.kdfAlgorithm = 0;
                break;
            case 3:
                this.hmacEnabled = true;
                this.kdfIteration = 64000;
                this.hmacAlgorithm = 0;
                this.kdfAlgorithm = 0;
                break;
            case 4:
                this.hmacEnabled = true;
                this.kdfIteration = 256000;
                this.hmacAlgorithm = 2;
                this.kdfAlgorithm = 2;
                break;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unsupported SQLCipher version: ".concat(String.valueOf(i)));
                AppMethodBeat.o(12270);
                throw illegalArgumentException;
        }
        AppMethodBeat.o(12270);
        return this;
    }
}
