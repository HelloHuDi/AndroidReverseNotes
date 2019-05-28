package com.tencent.ttpic.device;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.baseutils.LogUtils;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DeviceParser {
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0042 A:{SYNTHETIC, Splitter:B:13:0x0042} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00c6 A:{SYNTHETIC, Splitter:B:71:0x00c6} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00cb A:{Catch:{ IOException -> 0x00d9 }} */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00d0 A:{Catch:{ IOException -> 0x00d9 }} */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00d5 A:{Catch:{ IOException -> 0x00d9 }} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00b0 A:{SYNTHETIC, Splitter:B:62:0x00b0} */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00eb A:{SYNTHETIC, Splitter:B:86:0x00eb} */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00f0 A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x00f5 A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x00fa A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00eb A:{SYNTHETIC, Splitter:B:86:0x00eb} */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00f0 A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x00f5 A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x00fa A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00eb A:{SYNTHETIC, Splitter:B:86:0x00eb} */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00f0 A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x00f5 A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x00fa A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0065 A:{SYNTHETIC, Splitter:B:28:0x0065} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006a A:{Catch:{ IOException -> 0x00de }} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006f A:{Catch:{ IOException -> 0x00de }} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0074 A:{Catch:{ IOException -> 0x00de }} */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00eb A:{SYNTHETIC, Splitter:B:86:0x00eb} */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00f0 A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x00f5 A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x00fa A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0065 A:{SYNTHETIC, Splitter:B:28:0x0065} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006a A:{Catch:{ IOException -> 0x00de }} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006f A:{Catch:{ IOException -> 0x00de }} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0074 A:{Catch:{ IOException -> 0x00de }} */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00eb A:{SYNTHETIC, Splitter:B:86:0x00eb} */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00f0 A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x00f5 A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x00fa A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0065 A:{SYNTHETIC, Splitter:B:28:0x0065} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006a A:{Catch:{ IOException -> 0x00de }} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006f A:{Catch:{ IOException -> 0x00de }} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0074 A:{Catch:{ IOException -> 0x00de }} */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00eb A:{SYNTHETIC, Splitter:B:86:0x00eb} */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00f0 A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x00f5 A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x00fa A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0065 A:{SYNTHETIC, Splitter:B:28:0x0065} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006a A:{Catch:{ IOException -> 0x00de }} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006f A:{Catch:{ IOException -> 0x00de }} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0074 A:{Catch:{ IOException -> 0x00de }} */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00eb A:{SYNTHETIC, Splitter:B:86:0x00eb} */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00f0 A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x00f5 A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x00fa A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0065 A:{SYNTHETIC, Splitter:B:28:0x0065} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006a A:{Catch:{ IOException -> 0x00de }} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006f A:{Catch:{ IOException -> 0x00de }} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0074 A:{Catch:{ IOException -> 0x00de }} */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00eb A:{SYNTHETIC, Splitter:B:86:0x00eb} */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00f0 A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x00f5 A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x00fa A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00b0 A:{SYNTHETIC, Splitter:B:62:0x00b0} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String parseCameraAttrsFile(Context context, String str, String str2, String str3) {
        FileInputStream fileInputStream;
        InputStream inputStream;
        Throwable e;
        InputStream inputStream2;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        String str4;
        BufferedReader bufferedReader2;
        InputStreamReader inputStreamReader2;
        Throwable th;
        InputStream inputStream3;
        AppMethodBeat.i(49854);
        LogUtils.v("ContentValues", "[parseCameraAttrsFile] filePath = ".concat(String.valueOf(str)));
        try {
            File file = new File(str);
            InputStream fileInputStream2;
            InputStream drinkACupOfCoffeeForCamera;
            if (file.exists() && file.isFile()) {
                LogUtils.v("ContentValues", "[parseCameraAttrsFile] parseFile file exists and isFile");
                fileInputStream2 = new FileInputStream(file);
                try {
                    drinkACupOfCoffeeForCamera = drinkACupOfCoffeeForCamera(fileInputStream2, str2, str3);
                    try {
                        IOUtils.closeQuietly(fileInputStream2);
                        fileInputStream = fileInputStream2;
                        inputStream = drinkACupOfCoffeeForCamera;
                    } catch (Exception e2) {
                        e = e2;
                        inputStream2 = fileInputStream2;
                        inputStreamReader = null;
                        bufferedReader = null;
                        inputStream = drinkACupOfCoffeeForCamera;
                        LogUtils.e(e);
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e3) {
                                LogUtils.e(e3);
                                str4 = null;
                            }
                        }
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        str4 = null;
                        AppMethodBeat.o(49854);
                        return str4;
                    } catch (Throwable th2) {
                        e = th2;
                        inputStream2 = fileInputStream2;
                        inputStreamReader = null;
                        bufferedReader = null;
                        inputStream = drinkACupOfCoffeeForCamera;
                        if (bufferedReader != null) {
                        }
                        if (inputStreamReader != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        AppMethodBeat.o(49854);
                        throw e;
                    }
                } catch (Exception e4) {
                    e = e4;
                    inputStream2 = fileInputStream2;
                    inputStreamReader = null;
                    bufferedReader = null;
                    inputStream = null;
                } catch (Throwable th3) {
                    e = th3;
                    inputStream2 = fileInputStream2;
                    inputStreamReader = null;
                    bufferedReader = null;
                    inputStream = null;
                    if (bufferedReader != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    AppMethodBeat.o(49854);
                    throw e;
                }
            }
            InputStream open;
            LogUtils.v("ContentValues", "[parseCameraAttrsFile] parseFile file is in Assets directory");
            if (context != null) {
                try {
                    open = context.getAssets().open(str);
                    try {
                        fileInputStream2 = drinkACupOfCoffeeForCamera(open, str2, str3);
                        try {
                            IOUtils.closeQuietly(open);
                            drinkACupOfCoffeeForCamera = fileInputStream2;
                        } catch (IOException e5) {
                            if (open != null) {
                                try {
                                    open.close();
                                    fileInputStream = null;
                                    inputStream = fileInputStream2;
                                } catch (Exception e6) {
                                    e = e6;
                                    fileInputStream = null;
                                    inputStreamReader = null;
                                    bufferedReader = null;
                                    inputStream = fileInputStream2;
                                    try {
                                        LogUtils.e(e);
                                        if (bufferedReader != null) {
                                        }
                                        if (inputStreamReader != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        if (fileInputStream != null) {
                                        }
                                        str4 = null;
                                        AppMethodBeat.o(49854);
                                        return str4;
                                    } catch (Throwable th4) {
                                        e = th4;
                                        if (bufferedReader != null) {
                                        }
                                        if (inputStreamReader != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        if (fileInputStream != null) {
                                        }
                                        AppMethodBeat.o(49854);
                                        throw e;
                                    }
                                } catch (Throwable th5) {
                                    e = th5;
                                    fileInputStream = null;
                                    inputStreamReader = null;
                                    bufferedReader = null;
                                    inputStream = fileInputStream2;
                                    if (bufferedReader != null) {
                                    }
                                    if (inputStreamReader != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    if (fileInputStream != null) {
                                    }
                                    AppMethodBeat.o(49854);
                                    throw e;
                                }
                            }
                            fileInputStream = null;
                            inputStream = fileInputStream2;
                            if (inputStream == null) {
                            }
                            if (bufferedReader2 != null) {
                            }
                            if (inputStreamReader2 != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (fileInputStream != null) {
                            }
                            AppMethodBeat.o(49854);
                            return str4;
                        } catch (Throwable th6) {
                            th = th6;
                            inputStream3 = open;
                            drinkACupOfCoffeeForCamera = fileInputStream2;
                            if (inputStream3 != null) {
                                inputStream3.close();
                            }
                            AppMethodBeat.o(49854);
                            throw th;
                        }
                    } catch (IOException e7) {
                        fileInputStream2 = null;
                    } catch (Throwable th7) {
                        th = th7;
                        inputStream3 = open;
                        drinkACupOfCoffeeForCamera = null;
                        if (inputStream3 != null) {
                        }
                        AppMethodBeat.o(49854);
                        throw th;
                    }
                } catch (IOException e8) {
                    open = null;
                    fileInputStream2 = null;
                } catch (Throwable e9) {
                    th = e9;
                    inputStream3 = null;
                    drinkACupOfCoffeeForCamera = null;
                    if (inputStream3 != null) {
                    }
                    AppMethodBeat.o(49854);
                    throw th;
                }
            }
            open = null;
            drinkACupOfCoffeeForCamera = null;
            if (open != null) {
                try {
                    open.close();
                    fileInputStream = null;
                    inputStream = drinkACupOfCoffeeForCamera;
                } catch (Exception e10) {
                    e9 = e10;
                    fileInputStream = null;
                    inputStreamReader = null;
                    bufferedReader = null;
                    inputStream = drinkACupOfCoffeeForCamera;
                    LogUtils.e(e9);
                    if (bufferedReader != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    str4 = null;
                    AppMethodBeat.o(49854);
                    return str4;
                } catch (Throwable th8) {
                    e9 = th8;
                    fileInputStream = null;
                    inputStreamReader = null;
                    bufferedReader = null;
                    inputStream = drinkACupOfCoffeeForCamera;
                    if (bufferedReader != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    AppMethodBeat.o(49854);
                    throw e9;
                }
            }
            fileInputStream = null;
            inputStream = drinkACupOfCoffeeForCamera;
            if (inputStream == null) {
                try {
                    inputStreamReader2 = new InputStreamReader(inputStream);
                    try {
                        bufferedReader2 = new BufferedReader(inputStreamReader2, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                        try {
                            StringBuffer stringBuffer = new StringBuffer();
                            while (true) {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                stringBuffer.append(readLine);
                            }
                            str4 = stringBuffer.toString();
                        } catch (Exception e11) {
                            e9 = e11;
                            inputStreamReader = inputStreamReader2;
                            bufferedReader = bufferedReader2;
                        } catch (Throwable th9) {
                            e9 = th9;
                            inputStreamReader = inputStreamReader2;
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e12) {
                                    LogUtils.e(e12);
                                    AppMethodBeat.o(49854);
                                    throw e9;
                                }
                            }
                            if (inputStreamReader != null) {
                                inputStreamReader.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            AppMethodBeat.o(49854);
                            throw e9;
                        }
                    } catch (Exception e13) {
                        e9 = e13;
                        inputStreamReader = inputStreamReader2;
                        bufferedReader = null;
                        LogUtils.e(e9);
                        if (bufferedReader != null) {
                        }
                        if (inputStreamReader != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        str4 = null;
                        AppMethodBeat.o(49854);
                        return str4;
                    } catch (Throwable th10) {
                        e9 = th10;
                        inputStreamReader = inputStreamReader2;
                        bufferedReader = null;
                        if (bufferedReader != null) {
                        }
                        if (inputStreamReader != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        AppMethodBeat.o(49854);
                        throw e9;
                    }
                } catch (Exception e14) {
                    e9 = e14;
                    inputStreamReader = null;
                    bufferedReader = null;
                    LogUtils.e(e9);
                    if (bufferedReader != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    str4 = null;
                    AppMethodBeat.o(49854);
                    return str4;
                } catch (Throwable th11) {
                    e9 = th11;
                    inputStreamReader = null;
                    bufferedReader = null;
                    if (bufferedReader != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    AppMethodBeat.o(49854);
                    throw e9;
                }
            }
            inputStreamReader2 = null;
            bufferedReader2 = null;
            str4 = null;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e122) {
                    LogUtils.e(e122);
                }
            }
            if (inputStreamReader2 != null) {
                inputStreamReader2.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        } catch (Exception e15) {
            e9 = e15;
            fileInputStream = null;
            inputStreamReader = null;
            bufferedReader = null;
            inputStream = null;
            LogUtils.e(e9);
            if (bufferedReader != null) {
            }
            if (inputStreamReader != null) {
            }
            if (inputStream != null) {
            }
            if (fileInputStream != null) {
            }
            str4 = null;
            AppMethodBeat.o(49854);
            return str4;
        } catch (Throwable th12) {
            e9 = th12;
            fileInputStream = null;
            inputStreamReader = null;
            bufferedReader = null;
            inputStream = null;
            if (bufferedReader != null) {
            }
            if (inputStreamReader != null) {
            }
            if (inputStream != null) {
            }
            if (fileInputStream != null) {
            }
            AppMethodBeat.o(49854);
            throw e9;
        }
        AppMethodBeat.o(49854);
        return str4;
    }

    private static InputStream drinkACupOfCoffeeForCamera(InputStream inputStream, String str, String str2) {
        AppMethodBeat.i(49855);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(DeviceCoffee.drink(IOUtils.toByteArray(inputStream), str, str2));
        AppMethodBeat.o(49855);
        return byteArrayInputStream;
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003a A:{Catch:{ Exception -> 0x0088, all -> 0x00c7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0092 A:{SYNTHETIC, Splitter:B:56:0x0092} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0097 A:{Catch:{ IOException -> 0x00a0 }} */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x009c A:{Catch:{ IOException -> 0x00a0 }} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x007e A:{SYNTHETIC, Splitter:B:47:0x007e} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00b1 A:{SYNTHETIC, Splitter:B:69:0x00b1} */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00b6 A:{Catch:{ IOException -> 0x00c2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00bb A:{Catch:{ IOException -> 0x00c2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005c A:{SYNTHETIC, Splitter:B:29:0x005c} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0061 A:{Catch:{ IOException -> 0x00a5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0066 A:{Catch:{ IOException -> 0x00a5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00b1 A:{SYNTHETIC, Splitter:B:69:0x00b1} */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00b6 A:{Catch:{ IOException -> 0x00c2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00bb A:{Catch:{ IOException -> 0x00c2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00b1 A:{SYNTHETIC, Splitter:B:69:0x00b1} */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00b6 A:{Catch:{ IOException -> 0x00c2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00bb A:{Catch:{ IOException -> 0x00c2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005c A:{SYNTHETIC, Splitter:B:29:0x005c} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0061 A:{Catch:{ IOException -> 0x00a5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0066 A:{Catch:{ IOException -> 0x00a5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00b1 A:{SYNTHETIC, Splitter:B:69:0x00b1} */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00b6 A:{Catch:{ IOException -> 0x00c2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00bb A:{Catch:{ IOException -> 0x00c2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x007e A:{SYNTHETIC, Splitter:B:47:0x007e} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005c A:{SYNTHETIC, Splitter:B:29:0x005c} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0061 A:{Catch:{ IOException -> 0x00a5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0066 A:{Catch:{ IOException -> 0x00a5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00b1 A:{SYNTHETIC, Splitter:B:69:0x00b1} */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00b6 A:{Catch:{ IOException -> 0x00c2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00bb A:{Catch:{ IOException -> 0x00c2 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String parseFastCaptureFile(Context context, String str, String str2) {
        InputStream inputStream;
        Throwable e;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        String str3;
        InputStreamReader inputStreamReader2;
        Throwable th;
        InputStream inputStream2;
        AppMethodBeat.i(49856);
        LogUtils.v("ContentValues", "[parseFastCaptureFile] filePath = ".concat(String.valueOf(str)));
        try {
            InputStream open;
            LogUtils.v("ContentValues", "[parseFastCaptureFile] parseFile file is in Assets directory");
            if (context != null) {
                InputStream drinkACupOfCoffeeForFast;
                try {
                    open = context.getAssets().open(str);
                    try {
                        drinkACupOfCoffeeForFast = drinkACupOfCoffeeForFast(open, str2);
                        try {
                            IOUtils.closeQuietly(open);
                            inputStream = drinkACupOfCoffeeForFast;
                        } catch (IOException e2) {
                            if (open != null) {
                                try {
                                    open.close();
                                    inputStream = drinkACupOfCoffeeForFast;
                                } catch (Exception e3) {
                                    e = e3;
                                    inputStreamReader = null;
                                    bufferedReader = null;
                                    inputStream = drinkACupOfCoffeeForFast;
                                    try {
                                        LogUtils.e(e);
                                        if (bufferedReader != null) {
                                        }
                                        if (inputStreamReader != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        str3 = null;
                                        AppMethodBeat.o(49856);
                                        return str3;
                                    } catch (Throwable th2) {
                                        e = th2;
                                        if (bufferedReader != null) {
                                        }
                                        if (inputStreamReader != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        AppMethodBeat.o(49856);
                                        throw e;
                                    }
                                } catch (Throwable th3) {
                                    e = th3;
                                    inputStreamReader = null;
                                    bufferedReader = null;
                                    inputStream = drinkACupOfCoffeeForFast;
                                    if (bufferedReader != null) {
                                    }
                                    if (inputStreamReader != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    AppMethodBeat.o(49856);
                                    throw e;
                                }
                            }
                            inputStream = drinkACupOfCoffeeForFast;
                            if (inputStream == null) {
                            }
                            if (bufferedReader != null) {
                            }
                            if (inputStreamReader2 != null) {
                            }
                            if (inputStream != null) {
                            }
                            AppMethodBeat.o(49856);
                            return str3;
                        } catch (Throwable th4) {
                            th = th4;
                            inputStream2 = open;
                            inputStream = drinkACupOfCoffeeForFast;
                            if (inputStream2 != null) {
                            }
                            AppMethodBeat.o(49856);
                            throw th;
                        }
                    } catch (IOException e4) {
                        drinkACupOfCoffeeForFast = null;
                    } catch (Throwable th5) {
                        th = th5;
                        inputStream2 = open;
                        inputStream = null;
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        AppMethodBeat.o(49856);
                        throw th;
                    }
                } catch (IOException e5) {
                    open = null;
                    drinkACupOfCoffeeForFast = null;
                } catch (Throwable e6) {
                    th = e6;
                    inputStream2 = null;
                    inputStream = null;
                    if (inputStream2 != null) {
                    }
                    AppMethodBeat.o(49856);
                    throw th;
                }
            }
            open = null;
            inputStream = null;
            if (open != null) {
                try {
                    open.close();
                } catch (Exception e7) {
                    e6 = e7;
                    inputStreamReader = null;
                    bufferedReader = null;
                    LogUtils.e(e6);
                    if (bufferedReader != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (inputStream != null) {
                    }
                    str3 = null;
                    AppMethodBeat.o(49856);
                    return str3;
                } catch (Throwable th6) {
                    e6 = th6;
                    inputStreamReader = null;
                    bufferedReader = null;
                    if (bufferedReader != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (inputStream != null) {
                    }
                    AppMethodBeat.o(49856);
                    throw e6;
                }
            }
            if (inputStream == null) {
                inputStreamReader2 = new InputStreamReader(inputStream);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader2, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                } catch (Exception e8) {
                    e6 = e8;
                    inputStreamReader = inputStreamReader2;
                    bufferedReader = null;
                    LogUtils.e(e6);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e9) {
                            LogUtils.e(e9);
                            str3 = null;
                        }
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    str3 = null;
                    AppMethodBeat.o(49856);
                    return str3;
                } catch (Throwable th7) {
                    e6 = th7;
                    inputStreamReader = inputStreamReader2;
                    bufferedReader = null;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e10) {
                            LogUtils.e(e10);
                            AppMethodBeat.o(49856);
                            throw e6;
                        }
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    AppMethodBeat.o(49856);
                    throw e6;
                }
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    }
                    str3 = stringBuffer.toString();
                } catch (Exception e11) {
                    e6 = e11;
                    inputStreamReader = inputStreamReader2;
                } catch (Throwable th8) {
                    e6 = th8;
                    inputStreamReader = inputStreamReader2;
                    if (bufferedReader != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (inputStream != null) {
                    }
                    AppMethodBeat.o(49856);
                    throw e6;
                }
            }
            inputStreamReader2 = null;
            bufferedReader = null;
            str3 = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e102) {
                    LogUtils.e(e102);
                }
            }
            if (inputStreamReader2 != null) {
                inputStreamReader2.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Exception e12) {
            e6 = e12;
            inputStreamReader = null;
            bufferedReader = null;
            inputStream = null;
            LogUtils.e(e6);
            if (bufferedReader != null) {
            }
            if (inputStreamReader != null) {
            }
            if (inputStream != null) {
            }
            str3 = null;
            AppMethodBeat.o(49856);
            return str3;
        } catch (Throwable th9) {
            e6 = th9;
            inputStreamReader = null;
            bufferedReader = null;
            inputStream = null;
            if (bufferedReader != null) {
            }
            if (inputStreamReader != null) {
            }
            if (inputStream != null) {
            }
            AppMethodBeat.o(49856);
            throw e6;
        }
        AppMethodBeat.o(49856);
        return str3;
    }

    private static InputStream drinkACupOfCoffeeForFast(InputStream inputStream, String str) {
        AppMethodBeat.i(49857);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(DeviceCoffee.drinkRawData(IOUtils.toByteArray(inputStream), str));
        AppMethodBeat.o(49857);
        return byteArrayInputStream;
    }
}
