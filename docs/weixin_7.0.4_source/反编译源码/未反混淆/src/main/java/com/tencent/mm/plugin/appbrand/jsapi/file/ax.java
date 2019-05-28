package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import org.json.JSONObject;

final class ax extends d {
    ax() {
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x007a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final a a(c cVar, String str, JSONObject jSONObject) {
        AppMethodBeat.i(102840);
        String optString = jSONObject.optString("targetDirectory", "");
        a aVar;
        switch (cVar.asE().ye(optString)) {
            case ERR_PERMISSION_DENIED:
            case ERR_IS_FILE:
            case ERR_OP_FAIL:
                aVar = new a(String.format("fail permission denied, open \"%s\"", new Object[]{optString}), new Object[0]);
                AppMethodBeat.o(102840);
                return aVar;
            default:
                int i;
                File yg = cVar.asE().yg(str);
                if (yg == null || !yg.exists()) {
                    if (cVar.asE().yd(str) == j.OK) {
                        b yh = cVar.asE().yh(URLEncoder.encode(str));
                        if (yh != null) {
                            com.tencent.mm.plugin.appbrand.r.j jVar = new com.tencent.mm.plugin.appbrand.r.j();
                            cVar.asE().b(str, jVar);
                            try {
                                Channels.newChannel(e.q(yh)).write((ByteBuffer) jVar.value);
                                yg = new File(com.tencent.mm.vfs.j.w(yh.dMD()));
                                i = 1;
                            } catch (IOException e) {
                                ab.e("MicroMsg.AppBrand.FileSystem.UnitUnzip", "copy ByteBuffer failed e = %s", e);
                                yg = null;
                                i = 0;
                            }
                            if (yg == null) {
                                aVar = new a("fail no such file \"%s\"", str);
                                AppMethodBeat.o(102840);
                                return aVar;
                            }
                        }
                    }
                    i = 0;
                    if (yg == null) {
                    }
                } else if (yg.isDirectory() || l.F(yg)) {
                    aVar = new a("fail permission denied, open \"%s\"", str);
                    AppMethodBeat.o(102840);
                    return aVar;
                } else {
                    i = 0;
                }
                try {
                    j b = cVar.asE().b(optString, yg);
                    if (i != 0) {
                        e.deleteFile(yg.getAbsolutePath());
                    }
                    switch (b) {
                        case ERR_PERMISSION_DENIED:
                            aVar = new a("fail permission denied, open \"%s\"", str);
                            AppMethodBeat.o(102840);
                            return aVar;
                        case ERR_PARENT_DIR_NOT_EXISTS:
                            aVar = new a("fail no such file or directory, open \"%s\"", str);
                            AppMethodBeat.o(102840);
                            return aVar;
                        case RET_ALREADY_EXISTS:
                            aVar = new a("fail illegal operation on a filePath, open \"%s\"", str);
                            AppMethodBeat.o(102840);
                            return aVar;
                        case ERR_EXCEED_DIRECTORY_MAX_SIZE:
                            aVar = new a("fail the maximum size of the file storage limit is exceeded", new Object[0]);
                            AppMethodBeat.o(102840);
                            return aVar;
                        case ERR_BAD_ZIP_FILE:
                            aVar = new a("fail read zip data", new Object[0]);
                            AppMethodBeat.o(102840);
                            return aVar;
                        case ERR_WRITE_ZIP_ENTRY:
                            aVar = new a("fail write entry", new Object[0]);
                            AppMethodBeat.o(102840);
                            return aVar;
                        case OK:
                            aVar = new a("ok", new Object[0]);
                            AppMethodBeat.o(102840);
                            return aVar;
                        default:
                            aVar = new a("fail " + b.name(), new Object[0]);
                            AppMethodBeat.o(102840);
                            return aVar;
                    }
                } catch (Exception e2) {
                    ab.printErrStackTrace("MicroMsg.AppBrand.FileSystem.UnitUnzip", e2, "write zip stream", new Object[0]);
                    aVar = new a("fail read zip data", new Object[0]);
                    AppMethodBeat.o(102840);
                    return aVar;
                }
                ab.printErrStackTrace("MicroMsg.AppBrand.FileSystem.UnitUnzip", e2, "write zip stream", new Object[0]);
                aVar = new a("fail read zip data", new Object[0]);
                AppMethodBeat.o(102840);
                return aVar;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final String y(JSONObject jSONObject) {
        AppMethodBeat.i(102841);
        String optString = jSONObject.optString("zipFilePath");
        AppMethodBeat.o(102841);
        return optString;
    }
}
