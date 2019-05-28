package com.tencent.ttpic.ar.sensor.representation;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class MatrixF4x4 {
    public static final int[] matIndCol16_3x3 = new int[]{0, 1, 2, 4, 5, 6, 8, 9, 10};
    public static final int[] matIndCol16_4x4 = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    public static final int[] matIndCol9_3x3 = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
    public static final int[] matIndRow16_3x3 = new int[]{0, 4, 8, 1, 5, 9, 2, 6, 10};
    public static final int[] matIndRow16_4x4 = new int[]{0, 4, 8, 12, 1, 5, 9, 13, 2, 6, 10, 14, 3, 7, 11, 15};
    public static final int[] matIndRow9_3x3 = new int[]{0, 3, 6, 1, 4, 7, 3, 5, 8};
    private boolean colMaj = true;
    public float[] matrix = new float[16];

    public MatrixF4x4() {
        AppMethodBeat.i(81692);
        Matrix.setIdentityM(this.matrix, 0);
        AppMethodBeat.o(81692);
    }

    public float[] getMatrix() {
        return this.matrix;
    }

    public int size() {
        return this.matrix.length;
    }

    public void setMatrix(float[] fArr) {
        AppMethodBeat.i(81693);
        if (fArr.length == 16 || fArr.length == 9) {
            this.matrix = fArr;
            AppMethodBeat.o(81693);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Matrix set is invalid, size is " + fArr.length + " expected 9 or 16");
        AppMethodBeat.o(81693);
        throw illegalArgumentException;
    }

    public void set(MatrixF4x4 matrixF4x4) {
        AppMethodBeat.i(81694);
        System.arraycopy(matrixF4x4.matrix, 0, this.matrix, 0, this.matrix.length);
        AppMethodBeat.o(81694);
    }

    public void setColumnMajor(boolean z) {
        this.colMaj = z;
    }

    public boolean isColumnMajor() {
        return this.colMaj;
    }

    public void multiplyVector4fByMatrix(Vector4f vector4f) {
        int i = 0;
        AppMethodBeat.i(81695);
        if (this.matrix.length == 16) {
            float f;
            float f2;
            float f3;
            float f4;
            float[] array = vector4f.array();
            if (this.colMaj) {
                f = 0.0f;
                f2 = 0.0f;
                f3 = 0.0f;
                f4 = 0.0f;
                while (i < 4) {
                    int i2 = i * 4;
                    f4 += this.matrix[i2 + 0] * array[i];
                    f3 += this.matrix[i2 + 1] * array[i];
                    f2 += this.matrix[i2 + 2] * array[i];
                    f += this.matrix[i2 + 3] * array[i];
                    i++;
                }
            } else {
                f = 0.0f;
                f2 = 0.0f;
                f3 = 0.0f;
                f4 = 0.0f;
                while (i < 4) {
                    f4 += this.matrix[i + 0] * array[i];
                    f3 += this.matrix[i + 4] * array[i];
                    f2 += this.matrix[i + 8] * array[i];
                    f += this.matrix[i + 12] * array[i];
                    i++;
                }
            }
            vector4f.setX(f4);
            vector4f.setY(f3);
            vector4f.setZ(f2);
            vector4f.setW(f);
            AppMethodBeat.o(81695);
            return;
        }
        new StringBuilder("Matrix is invalid, is ").append(this.matrix.length).append(" long, this equation expects a 16 value matrix");
        AppMethodBeat.o(81695);
    }

    public void multiplyVector3fByMatrix(Vector3f vector3f) {
        int i = 0;
        AppMethodBeat.i(81696);
        if (this.matrix.length == 9) {
            float f;
            float f2;
            float f3;
            float[] toArray = vector3f.toArray();
            if (this.colMaj) {
                f = 0.0f;
                f2 = 0.0f;
                f3 = 0.0f;
                while (i < 3) {
                    f3 += this.matrix[i + 0] * toArray[i];
                    f2 += this.matrix[i + 3] * toArray[i];
                    f += this.matrix[i + 6] * toArray[i];
                    i++;
                }
            } else {
                f = 0.0f;
                f2 = 0.0f;
                f3 = 0.0f;
                while (i < 3) {
                    int i2 = i * 3;
                    f3 += this.matrix[i2 + 0] * toArray[i];
                    f2 += this.matrix[i2 + 1] * toArray[i];
                    f += this.matrix[i2 + 2] * toArray[i];
                    i++;
                }
            }
            vector3f.setX(f3);
            vector3f.setY(f2);
            vector3f.setZ(f);
            AppMethodBeat.o(81696);
            return;
        }
        new StringBuilder("Matrix is invalid, is ").append(this.matrix.length).append(" long, this function expects the internal matrix to be of size 9");
        AppMethodBeat.o(81696);
    }

    public void multiplyMatrix4x4ByMatrix(MatrixF4x4 matrixF4x4) {
        AppMethodBeat.i(81697);
        float[] fArr = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        multiplyMatrix(matrixF4x4.getMatrix(), 0, fArr, 0);
        matrixF4x4.setMatrix(fArr);
        AppMethodBeat.o(81697);
    }

    public void multiplyMatrix(float[] fArr, int i, float[] fArr2, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            for (int i4 = 0; i4 < 4; i4++) {
                int i5 = i3 * 4;
                int i6 = (i2 + 0) + i4;
                fArr2[i6] = fArr2[i6] + (this.matrix[i5 + i4] * fArr[(i + 0) + i3]);
                i6 = (i2 + 4) + i4;
                fArr2[i6] = fArr2[i6] + (this.matrix[i5 + i4] * fArr[(i + 4) + i3]);
                i6 = (i2 + 8) + i4;
                fArr2[i6] = fArr2[i6] + (this.matrix[i5 + i4] * fArr[(i + 8) + i3]);
                i6 = (i2 + 12) + i4;
                fArr2[i6] = (this.matrix[i5 + i4] * fArr[(i + 12) + i3]) + fArr2[i6];
            }
        }
    }

    public void transpose() {
        int i = 0;
        float[] fArr;
        int i2;
        if (this.matrix.length == 16) {
            fArr = new float[16];
            while (i < 4) {
                i2 = i * 4;
                fArr[i2] = this.matrix[i];
                fArr[i2 + 1] = this.matrix[i + 4];
                fArr[i2 + 2] = this.matrix[i + 8];
                fArr[i2 + 3] = this.matrix[i + 12];
                i++;
            }
            this.matrix = fArr;
            return;
        }
        fArr = new float[9];
        while (i < 3) {
            i2 = i * 3;
            fArr[i2] = this.matrix[i];
            fArr[i2 + 1] = this.matrix[i + 3];
            fArr[i2 + 2] = this.matrix[i + 6];
            i++;
        }
        this.matrix = fArr;
    }

    public void setX0(float f) {
        if (this.matrix.length == 16) {
            if (this.colMaj) {
                this.matrix[matIndCol16_3x3[0]] = f;
            } else {
                this.matrix[matIndRow16_3x3[0]] = f;
            }
        } else if (this.colMaj) {
            this.matrix[matIndCol9_3x3[0]] = f;
        } else {
            this.matrix[matIndRow9_3x3[0]] = f;
        }
    }

    public void setX1(float f) {
        if (this.matrix.length == 16) {
            if (this.colMaj) {
                this.matrix[matIndCol16_3x3[1]] = f;
            } else {
                this.matrix[matIndRow16_3x3[1]] = f;
            }
        } else if (this.colMaj) {
            this.matrix[matIndCol9_3x3[1]] = f;
        } else {
            this.matrix[matIndRow9_3x3[1]] = f;
        }
    }

    public void setX2(float f) {
        if (this.matrix.length == 16) {
            if (this.colMaj) {
                this.matrix[matIndCol16_3x3[2]] = f;
            } else {
                this.matrix[matIndRow16_3x3[2]] = f;
            }
        } else if (this.colMaj) {
            this.matrix[matIndCol9_3x3[2]] = f;
        } else {
            this.matrix[matIndRow9_3x3[2]] = f;
        }
    }

    public void setY0(float f) {
        if (this.matrix.length == 16) {
            if (this.colMaj) {
                this.matrix[matIndCol16_3x3[3]] = f;
            } else {
                this.matrix[matIndRow16_3x3[3]] = f;
            }
        } else if (this.colMaj) {
            this.matrix[matIndCol9_3x3[3]] = f;
        } else {
            this.matrix[matIndRow9_3x3[3]] = f;
        }
    }

    public void setY1(float f) {
        if (this.matrix.length == 16) {
            if (this.colMaj) {
                this.matrix[matIndCol16_3x3[4]] = f;
            } else {
                this.matrix[matIndRow16_3x3[4]] = f;
            }
        } else if (this.colMaj) {
            this.matrix[matIndCol9_3x3[4]] = f;
        } else {
            this.matrix[matIndRow9_3x3[4]] = f;
        }
    }

    public void setY2(float f) {
        if (this.matrix.length == 16) {
            if (this.colMaj) {
                this.matrix[matIndCol16_3x3[5]] = f;
            } else {
                this.matrix[matIndRow16_3x3[5]] = f;
            }
        } else if (this.colMaj) {
            this.matrix[matIndCol9_3x3[5]] = f;
        } else {
            this.matrix[matIndRow9_3x3[5]] = f;
        }
    }

    public void setZ0(float f) {
        if (this.matrix.length == 16) {
            if (this.colMaj) {
                this.matrix[matIndCol16_3x3[6]] = f;
            } else {
                this.matrix[matIndRow16_3x3[6]] = f;
            }
        } else if (this.colMaj) {
            this.matrix[matIndCol9_3x3[6]] = f;
        } else {
            this.matrix[matIndRow9_3x3[6]] = f;
        }
    }

    public void setZ1(float f) {
        if (this.matrix.length == 16) {
            if (this.colMaj) {
                this.matrix[matIndCol16_3x3[7]] = f;
            } else {
                this.matrix[matIndRow16_3x3[7]] = f;
            }
        } else if (this.colMaj) {
            this.matrix[matIndCol9_3x3[7]] = f;
        } else {
            this.matrix[matIndRow9_3x3[7]] = f;
        }
    }

    public void setZ2(float f) {
        if (this.matrix.length == 16) {
            if (this.colMaj) {
                this.matrix[matIndCol16_3x3[8]] = f;
            } else {
                this.matrix[matIndRow16_3x3[8]] = f;
            }
        } else if (this.colMaj) {
            this.matrix[matIndCol9_3x3[8]] = f;
        } else {
            this.matrix[matIndRow9_3x3[8]] = f;
        }
    }

    public void setX3(float f) {
        AppMethodBeat.i(81698);
        if (this.matrix.length != 16) {
            IllegalStateException illegalStateException = new IllegalStateException("length of matrix should be 16");
            AppMethodBeat.o(81698);
            throw illegalStateException;
        } else if (this.colMaj) {
            this.matrix[matIndCol16_4x4[3]] = f;
            AppMethodBeat.o(81698);
        } else {
            this.matrix[matIndRow16_4x4[3]] = f;
            AppMethodBeat.o(81698);
        }
    }

    public void setY3(float f) {
        AppMethodBeat.i(81699);
        if (this.matrix.length != 16) {
            IllegalStateException illegalStateException = new IllegalStateException("length of matrix should be 16");
            AppMethodBeat.o(81699);
            throw illegalStateException;
        } else if (this.colMaj) {
            this.matrix[matIndCol16_4x4[7]] = f;
            AppMethodBeat.o(81699);
        } else {
            this.matrix[matIndRow16_4x4[7]] = f;
            AppMethodBeat.o(81699);
        }
    }

    public void setZ3(float f) {
        AppMethodBeat.i(81700);
        if (this.matrix.length != 16) {
            IllegalStateException illegalStateException = new IllegalStateException("length of matrix should be 16");
            AppMethodBeat.o(81700);
            throw illegalStateException;
        } else if (this.colMaj) {
            this.matrix[matIndCol16_4x4[11]] = f;
            AppMethodBeat.o(81700);
        } else {
            this.matrix[matIndRow16_4x4[11]] = f;
            AppMethodBeat.o(81700);
        }
    }

    public void setW0(float f) {
        AppMethodBeat.i(81701);
        if (this.matrix.length != 16) {
            IllegalStateException illegalStateException = new IllegalStateException("length of matrix should be 16");
            AppMethodBeat.o(81701);
            throw illegalStateException;
        } else if (this.colMaj) {
            this.matrix[matIndCol16_4x4[12]] = f;
            AppMethodBeat.o(81701);
        } else {
            this.matrix[matIndRow16_4x4[12]] = f;
            AppMethodBeat.o(81701);
        }
    }

    public void setW1(float f) {
        AppMethodBeat.i(81702);
        if (this.matrix.length != 16) {
            IllegalStateException illegalStateException = new IllegalStateException("length of matrix should be 16");
            AppMethodBeat.o(81702);
            throw illegalStateException;
        } else if (this.colMaj) {
            this.matrix[matIndCol16_4x4[13]] = f;
            AppMethodBeat.o(81702);
        } else {
            this.matrix[matIndRow16_4x4[13]] = f;
            AppMethodBeat.o(81702);
        }
    }

    public void setW2(float f) {
        AppMethodBeat.i(81703);
        if (this.matrix.length != 16) {
            IllegalStateException illegalStateException = new IllegalStateException("length of matrix should be 16");
            AppMethodBeat.o(81703);
            throw illegalStateException;
        } else if (this.colMaj) {
            this.matrix[matIndCol16_4x4[14]] = f;
            AppMethodBeat.o(81703);
        } else {
            this.matrix[matIndRow16_4x4[14]] = f;
            AppMethodBeat.o(81703);
        }
    }

    public void setW3(float f) {
        AppMethodBeat.i(81704);
        if (this.matrix.length != 16) {
            IllegalStateException illegalStateException = new IllegalStateException("length of matrix should be 16");
            AppMethodBeat.o(81704);
            throw illegalStateException;
        } else if (this.colMaj) {
            this.matrix[matIndCol16_4x4[15]] = f;
            AppMethodBeat.o(81704);
        } else {
            this.matrix[matIndRow16_4x4[15]] = f;
            AppMethodBeat.o(81704);
        }
    }
}
