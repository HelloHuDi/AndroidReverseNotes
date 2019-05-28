package com.tencent.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

final class c {
    static List<String> s(File file) {
        AppMethodBeat.i(125742);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                arrayList.add(readLine.trim());
            } else {
                fileReader.close();
                bufferedReader.close();
                AppMethodBeat.o(125742);
                return arrayList;
            }
        }
    }

    static File cl(String str) {
        AppMethodBeat.i(125743);
        File file = new File(str);
        if (file.exists()) {
            AppMethodBeat.o(125743);
        } else {
            if (!file.getParentFile().exists()) {
                cl(file.getParentFile().getAbsolutePath());
            }
            file.mkdir();
            AppMethodBeat.o(125743);
        }
        return file;
    }
}
