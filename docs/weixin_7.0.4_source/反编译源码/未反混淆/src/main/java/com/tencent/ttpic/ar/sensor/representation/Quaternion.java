package com.tencent.ttpic.ar.sensor.representation;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Quaternion extends Vector4f {
    private boolean dirty = false;
    private MatrixF4x4 matrix = new MatrixF4x4();
    private Quaternion tmpQuaternion;
    private Vector4f tmpVector = new Vector4f();

    public Quaternion() {
        AppMethodBeat.i(81705);
        loadIdentityQuat();
        AppMethodBeat.o(81705);
    }

    public void normalise() {
        AppMethodBeat.i(81706);
        this.dirty = true;
        float sqrt = (float) Math.sqrt((double) ((((this.points[3] * this.points[3]) + (this.points[0] * this.points[0])) + (this.points[1] * this.points[1])) + (this.points[2] * this.points[2])));
        this.points[3] = this.points[3] / sqrt;
        this.points[0] = this.points[0] / sqrt;
        this.points[1] = this.points[1] / sqrt;
        this.points[2] = this.points[2] / sqrt;
        AppMethodBeat.o(81706);
    }

    public void normalize() {
        AppMethodBeat.i(81707);
        normalise();
        AppMethodBeat.o(81707);
    }

    public void set(Quaternion quaternion) {
        AppMethodBeat.i(81708);
        this.dirty = true;
        copyVec4(quaternion);
        AppMethodBeat.o(81708);
    }

    public void multiplyByQuat(Quaternion quaternion, Quaternion quaternion2) {
        if (quaternion != quaternion2) {
            quaternion2.points[3] = (((this.points[3] * quaternion.points[3]) - (this.points[0] * quaternion.points[0])) - (this.points[1] * quaternion.points[1])) - (this.points[2] * quaternion.points[2]);
            quaternion2.points[0] = (((this.points[3] * quaternion.points[0]) + (this.points[0] * quaternion.points[3])) + (this.points[1] * quaternion.points[2])) - (this.points[2] * quaternion.points[1]);
            quaternion2.points[1] = (((this.points[3] * quaternion.points[1]) + (this.points[1] * quaternion.points[3])) + (this.points[2] * quaternion.points[0])) - (this.points[0] * quaternion.points[2]);
            quaternion2.points[2] = (((this.points[3] * quaternion.points[2]) + (this.points[2] * quaternion.points[3])) + (this.points[0] * quaternion.points[1])) - (this.points[1] * quaternion.points[0]);
            return;
        }
        this.tmpVector.points[0] = quaternion.points[0];
        this.tmpVector.points[1] = quaternion.points[1];
        this.tmpVector.points[2] = quaternion.points[2];
        this.tmpVector.points[3] = quaternion.points[3];
        quaternion2.points[3] = (((this.points[3] * this.tmpVector.points[3]) - (this.points[0] * this.tmpVector.points[0])) - (this.points[1] * this.tmpVector.points[1])) - (this.points[2] * this.tmpVector.points[2]);
        quaternion2.points[0] = (((this.points[3] * this.tmpVector.points[0]) + (this.points[0] * this.tmpVector.points[3])) + (this.points[1] * this.tmpVector.points[2])) - (this.points[2] * this.tmpVector.points[1]);
        quaternion2.points[1] = (((this.points[3] * this.tmpVector.points[1]) + (this.points[1] * this.tmpVector.points[3])) + (this.points[2] * this.tmpVector.points[0])) - (this.points[0] * this.tmpVector.points[2]);
        quaternion2.points[2] = (((this.points[3] * this.tmpVector.points[2]) + (this.points[2] * this.tmpVector.points[3])) + (this.points[0] * this.tmpVector.points[1])) - (this.points[1] * this.tmpVector.points[0]);
    }

    public void multiplyByQuat(Quaternion quaternion) {
        AppMethodBeat.i(81709);
        this.dirty = true;
        if (this.tmpQuaternion == null) {
            this.tmpQuaternion = new Quaternion();
        }
        this.tmpQuaternion.copyVec4(this);
        multiplyByQuat(quaternion, this.tmpQuaternion);
        copyVec4(this.tmpQuaternion);
        AppMethodBeat.o(81709);
    }

    public void multiplyByScalar(float f) {
        AppMethodBeat.i(81710);
        this.dirty = true;
        multiplyByScalar(f);
        AppMethodBeat.o(81710);
    }

    public void addQuat(Quaternion quaternion) {
        AppMethodBeat.i(81711);
        this.dirty = true;
        addQuat(quaternion, this);
        AppMethodBeat.o(81711);
    }

    public void addQuat(Quaternion quaternion, Quaternion quaternion2) {
        AppMethodBeat.i(81712);
        quaternion2.setX(getX() + quaternion.getX());
        quaternion2.setY(getY() + quaternion.getY());
        quaternion2.setZ(getZ() + quaternion.getZ());
        quaternion2.setW(getW() + quaternion.getW());
        AppMethodBeat.o(81712);
    }

    public void subQuat(Quaternion quaternion) {
        AppMethodBeat.i(81713);
        this.dirty = true;
        subQuat(quaternion, this);
        AppMethodBeat.o(81713);
    }

    public void subQuat(Quaternion quaternion, Quaternion quaternion2) {
        AppMethodBeat.i(81714);
        quaternion2.setX(getX() - quaternion.getX());
        quaternion2.setY(getY() - quaternion.getY());
        quaternion2.setZ(getZ() - quaternion.getZ());
        quaternion2.setW(getW() - quaternion.getW());
        AppMethodBeat.o(81714);
    }

    private void convertQuatToMatrix() {
        AppMethodBeat.i(81715);
        float f = this.points[0];
        float f2 = this.points[1];
        float f3 = this.points[2];
        float f4 = this.points[3];
        this.matrix.setX0((1.0f - ((f2 * f2) * 2.0f)) - ((f3 * f3) * 2.0f));
        this.matrix.setX1(((f * f2) * 2.0f) + ((f4 * f3) * 2.0f));
        this.matrix.setX2(((f * f3) * 2.0f) - ((f4 * f2) * 2.0f));
        this.matrix.setX3(0.0f);
        this.matrix.setY0(((f * f2) * 2.0f) - ((f4 * f3) * 2.0f));
        this.matrix.setY1((1.0f - ((f * f) * 2.0f)) - ((f3 * f3) * 2.0f));
        this.matrix.setY2(((f2 * f3) * 2.0f) + ((f4 * f) * 2.0f));
        this.matrix.setY3(0.0f);
        this.matrix.setZ0(((f * f3) * 2.0f) + ((f4 * f2) * 2.0f));
        this.matrix.setZ1(((f3 * f2) * 2.0f) - ((f4 * f) * 2.0f));
        this.matrix.setZ2((1.0f - ((f * f) * 2.0f)) - ((f2 * f2) * 2.0f));
        this.matrix.setZ3(0.0f);
        this.matrix.setW0(0.0f);
        this.matrix.setW1(0.0f);
        this.matrix.setW2(0.0f);
        this.matrix.setW3(1.0f);
        AppMethodBeat.o(81715);
    }

    public void toAxisAngle(Vector4f vector4f) {
        float f;
        float f2;
        AppMethodBeat.i(81716);
        if (getW() > 1.0f) {
            normalise();
        }
        float toDegrees = 2.0f * ((float) Math.toDegrees(Math.acos((double) getW())));
        float sqrt = (float) Math.sqrt((double) (1.0f - (getW() * getW())));
        if (((double) sqrt) < 0.001d) {
            f = this.points[0];
            f2 = this.points[1];
            sqrt = this.points[2];
        } else {
            f = this.points[0] / sqrt;
            f2 = this.points[1] / sqrt;
            sqrt = this.points[2] / sqrt;
        }
        vector4f.points[0] = f;
        vector4f.points[1] = f2;
        vector4f.points[2] = sqrt;
        vector4f.points[3] = toDegrees;
        AppMethodBeat.o(81716);
    }

    public double[] toEulerAngles() {
        AppMethodBeat.i(81717);
        double[] dArr = new double[]{Math.atan2((double) (((this.points[1] * 2.0f) * getW()) - ((this.points[0] * 2.0f) * this.points[2])), (double) ((1.0f - ((this.points[1] * this.points[1]) * 2.0f)) - ((this.points[2] * this.points[2]) * 2.0f))), Math.asin((double) (((this.points[0] * 2.0f) * this.points[1]) + ((this.points[2] * 2.0f) * getW()))), Math.atan2((double) (((this.points[0] * 2.0f) * getW()) - ((this.points[1] * 2.0f) * this.points[2])), (double) ((1.0f - ((this.points[0] * this.points[0]) * 2.0f)) - ((this.points[2] * this.points[2]) * 2.0f)))};
        AppMethodBeat.o(81717);
        return dArr;
    }

    public void loadIdentityQuat() {
        AppMethodBeat.i(81718);
        this.dirty = true;
        setX(0.0f);
        setY(0.0f);
        setZ(0.0f);
        setW(1.0f);
        AppMethodBeat.o(81718);
    }

    public String toString() {
        AppMethodBeat.i(81719);
        String str = "{X: " + getX() + ", Y:" + getY() + ", Z:" + getZ() + ", W:" + getW() + "}";
        AppMethodBeat.o(81719);
        return str;
    }

    private void generateQuaternionFromMatrix() {
        int[] iArr;
        float f;
        float f2;
        float f3;
        AppMethodBeat.i(81720);
        float[] matrix = this.matrix.getMatrix();
        if (this.matrix.size() == 16) {
            if (this.matrix.isColumnMajor()) {
                iArr = MatrixF4x4.matIndCol16_3x3;
            } else {
                iArr = MatrixF4x4.matIndRow16_3x3;
            }
        } else if (this.matrix.isColumnMajor()) {
            iArr = MatrixF4x4.matIndCol9_3x3;
        } else {
            iArr = MatrixF4x4.matIndRow9_3x3;
        }
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        int i9 = iArr[8];
        float f4 = (matrix[i] + matrix[i5]) + matrix[i9];
        float sqrt;
        if (f4 > 0.0f) {
            sqrt = ((float) Math.sqrt(((double) f4) + 1.0d)) * 2.0f;
            f4 = 0.25f * sqrt;
            f = (matrix[i8] - matrix[i6]) / sqrt;
            f2 = (matrix[i3] - matrix[i7]) / sqrt;
            f3 = (matrix[i4] - matrix[i2]) / sqrt;
        } else {
            if (((matrix[i] > matrix[i5] ? 1 : 0) & (matrix[i] > matrix[i9] ? 1 : 0)) != 0) {
                sqrt = ((float) Math.sqrt(((1.0d + ((double) matrix[i])) - ((double) matrix[i5])) - ((double) matrix[i9]))) * 2.0f;
                f4 = (matrix[i8] - matrix[i6]) / sqrt;
                f = 0.25f * sqrt;
                f2 = (matrix[i2] + matrix[i4]) / sqrt;
                f3 = (matrix[i7] + matrix[i3]) / sqrt;
            } else if (matrix[i5] > matrix[i9]) {
                sqrt = ((float) Math.sqrt(((1.0d + ((double) matrix[i5])) - ((double) matrix[i])) - ((double) matrix[i9]))) * 2.0f;
                f4 = (matrix[i3] - matrix[i7]) / sqrt;
                f = (matrix[i2] + matrix[i4]) / sqrt;
                f2 = 0.25f * sqrt;
                f3 = (matrix[i8] + matrix[i6]) / sqrt;
            } else {
                sqrt = ((float) Math.sqrt(((1.0d + ((double) matrix[i9])) - ((double) matrix[i])) - ((double) matrix[i5]))) * 2.0f;
                f4 = (matrix[i4] - matrix[i2]) / sqrt;
                f = (matrix[i3] + matrix[i7]) / sqrt;
                f2 = (matrix[i6] + matrix[i8]) / sqrt;
                f3 = 0.25f * sqrt;
            }
        }
        setX(f);
        setY(f2);
        setZ(f3);
        setW(f4);
        AppMethodBeat.o(81720);
    }

    public void setColumnMajor(float[] fArr) {
        AppMethodBeat.i(81721);
        this.matrix.setMatrix(fArr);
        this.matrix.setColumnMajor(true);
        generateQuaternionFromMatrix();
        AppMethodBeat.o(81721);
    }

    public void setRowMajor(float[] fArr) {
        AppMethodBeat.i(81722);
        this.matrix.setMatrix(fArr);
        this.matrix.setColumnMajor(false);
        generateQuaternionFromMatrix();
        AppMethodBeat.o(81722);
    }

    public void setEulerAngle(float f, float f2, float f3) {
        AppMethodBeat.i(81723);
        double toRadians = Math.toRadians((double) f3);
        double toRadians2 = Math.toRadians((double) f2);
        double toRadians3 = Math.toRadians((double) f);
        double cos = Math.cos(toRadians / 2.0d);
        toRadians = Math.sin(toRadians / 2.0d);
        double cos2 = Math.cos(toRadians2 / 2.0d);
        toRadians2 = Math.sin(toRadians2 / 2.0d);
        double cos3 = Math.cos(toRadians3 / 2.0d);
        toRadians3 = Math.sin(toRadians3 / 2.0d);
        double d = cos * cos2;
        double d2 = toRadians * toRadians2;
        setW((float) ((d * cos3) - (d2 * toRadians3)));
        setX((float) ((d * toRadians3) + (d2 * cos3)));
        setY((float) (((toRadians * cos2) * cos3) + ((cos * toRadians2) * toRadians3)));
        setZ((float) (((toRadians2 * cos) * cos3) - ((toRadians * cos2) * toRadians3)));
        this.dirty = true;
        AppMethodBeat.o(81723);
    }

    public void setAxisAngle(Vector3f vector3f, float f) {
        AppMethodBeat.i(81724);
        double sin = Math.sin(Math.toRadians((double) (f / 2.0f)));
        setX(vector3f.getX() * ((float) sin));
        setY(vector3f.getY() * ((float) sin));
        setZ(((float) sin) * vector3f.getZ());
        setW((float) Math.cos(Math.toRadians((double) (f / 2.0f))));
        this.dirty = true;
        AppMethodBeat.o(81724);
    }

    public void setAxisAngleRad(Vector3f vector3f, double d) {
        AppMethodBeat.i(81725);
        double d2 = d / 2.0d;
        setX(vector3f.getX() * ((float) d2));
        setY(vector3f.getY() * ((float) d2));
        setZ(((float) d2) * vector3f.getZ());
        setW(((float) d) / 2.0f);
        this.dirty = true;
        AppMethodBeat.o(81725);
    }

    public MatrixF4x4 getMatrix4x4() {
        AppMethodBeat.i(81726);
        if (this.dirty) {
            convertQuatToMatrix();
            this.dirty = false;
        }
        MatrixF4x4 matrixF4x4 = this.matrix;
        AppMethodBeat.o(81726);
        return matrixF4x4;
    }

    public void copyFromVec3(Vector3f vector3f, float f) {
        AppMethodBeat.i(81727);
        copyFromV3f(vector3f, f);
        AppMethodBeat.o(81727);
    }

    public void slerp(Quaternion quaternion, Quaternion quaternion2, float f) {
        AppMethodBeat.i(81728);
        float dotProduct = dotProduct(quaternion);
        if (dotProduct < 0.0f) {
            if (this.tmpQuaternion == null) {
                this.tmpQuaternion = new Quaternion();
            }
            Quaternion quaternion3 = this.tmpQuaternion;
            dotProduct = -dotProduct;
            quaternion3.points[0] = -quaternion.points[0];
            quaternion3.points[1] = -quaternion.points[1];
            quaternion3.points[2] = -quaternion.points[2];
            quaternion3.points[3] = -quaternion.points[3];
            quaternion = quaternion3;
        }
        if (((double) Math.abs(dotProduct)) >= 1.0d) {
            quaternion2.points[0] = this.points[0];
            quaternion2.points[1] = this.points[1];
            quaternion2.points[2] = this.points[2];
            quaternion2.points[3] = this.points[3];
            AppMethodBeat.o(81728);
            return;
        }
        double sqrt = Math.sqrt(1.0d - ((double) (dotProduct * dotProduct)));
        double acos = Math.acos((double) dotProduct);
        double sin = Math.sin(((double) (1.0f - f)) * acos) / sqrt;
        acos = Math.sin(acos * ((double) f)) / sqrt;
        quaternion2.points[3] = (float) ((((double) this.points[3]) * sin) + (((double) quaternion.points[3]) * acos));
        quaternion2.points[0] = (float) ((((double) this.points[0]) * sin) + (((double) quaternion.points[0]) * acos));
        quaternion2.points[1] = (float) ((((double) this.points[1]) * sin) + (((double) quaternion.points[1]) * acos));
        quaternion2.points[2] = (float) ((acos * ((double) quaternion.points[2])) + (sin * ((double) this.points[2])));
        AppMethodBeat.o(81728);
    }
}
