.class Landroidx/versionedparcelable/c;
.super Landroidx/versionedparcelable/b;
.source ""


# instance fields
.field private final a:Landroid/util/SparseIntArray;

.field private final b:Landroid/os/Parcel;

.field private final c:I

.field private final d:I

.field private final e:Ljava/lang/String;

.field private f:I

.field private g:I


# direct methods
.method constructor <init>(Landroid/os/Parcel;)V
    .locals 3
    .param p1, "p"    # Landroid/os/Parcel;

    .line 46
    invoke-virtual {p1}, Landroid/os/Parcel;->dataPosition()I

    move-result v0

    invoke-virtual {p1}, Landroid/os/Parcel;->dataSize()I

    move-result v1

    const-string v2, ""

    invoke-direct {p0, p1, v0, v1, v2}, Landroidx/versionedparcelable/c;-><init>(Landroid/os/Parcel;IILjava/lang/String;)V

    .line 47
    return-void
.end method

.method constructor <init>(Landroid/os/Parcel;IILjava/lang/String;)V
    .locals 1
    .param p1, "p"    # Landroid/os/Parcel;
    .param p2, "offset"    # I
    .param p3, "end"    # I
    .param p4, "prefix"    # Ljava/lang/String;

    .line 49
    invoke-direct {p0}, Landroidx/versionedparcelable/b;-><init>()V

    .line 37
    new-instance v0, Landroid/util/SparseIntArray;

    invoke-direct {v0}, Landroid/util/SparseIntArray;-><init>()V

    iput-object v0, p0, Landroidx/versionedparcelable/c;->a:Landroid/util/SparseIntArray;

    .line 42
    const/4 v0, -0x1

    iput v0, p0, Landroidx/versionedparcelable/c;->f:I

    .line 43
    const/4 v0, 0x0

    iput v0, p0, Landroidx/versionedparcelable/c;->g:I

    .line 50
    iput-object p1, p0, Landroidx/versionedparcelable/c;->b:Landroid/os/Parcel;

    .line 51
    iput p2, p0, Landroidx/versionedparcelable/c;->c:I

    .line 52
    iput p3, p0, Landroidx/versionedparcelable/c;->d:I

    .line 53
    iget v0, p0, Landroidx/versionedparcelable/c;->c:I

    iput v0, p0, Landroidx/versionedparcelable/c;->g:I

    .line 54
    iput-object p4, p0, Landroidx/versionedparcelable/c;->e:Ljava/lang/String;

    .line 55
    return-void
.end method

.method private d(I)I
    .locals 3
    .param p1, "fieldId"    # I

    .line 58
    :goto_0
    iget v0, p0, Landroidx/versionedparcelable/c;->g:I

    iget v1, p0, Landroidx/versionedparcelable/c;->d:I

    if-ge v0, v1, :cond_1

    .line 59
    iget-object v1, p0, Landroidx/versionedparcelable/c;->b:Landroid/os/Parcel;

    invoke-virtual {v1, v0}, Landroid/os/Parcel;->setDataPosition(I)V

    .line 60
    iget-object v0, p0, Landroidx/versionedparcelable/c;->b:Landroid/os/Parcel;

    invoke-virtual {v0}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .line 61
    .local v0, "size":I
    iget-object v1, p0, Landroidx/versionedparcelable/c;->b:Landroid/os/Parcel;

    invoke-virtual {v1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .line 64
    .local v1, "fid":I
    iget v2, p0, Landroidx/versionedparcelable/c;->g:I

    add-int/2addr v2, v0

    iput v2, p0, Landroidx/versionedparcelable/c;->g:I

    .line 65
    if-ne v1, p1, :cond_0

    iget-object v2, p0, Landroidx/versionedparcelable/c;->b:Landroid/os/Parcel;

    invoke-virtual {v2}, Landroid/os/Parcel;->dataPosition()I

    move-result v2

    return v2

    .line 66
    .end local v0    # "size":I
    .end local v1    # "fid":I
    :cond_0
    goto :goto_0

    .line 67
    :cond_1
    const/4 v0, -0x1

    return v0
.end method


# virtual methods
.method public a()V
    .locals 4

    .line 93
    iget v0, p0, Landroidx/versionedparcelable/c;->f:I

    if-ltz v0, :cond_0

    .line 94
    iget-object v1, p0, Landroidx/versionedparcelable/c;->a:Landroid/util/SparseIntArray;

    invoke-virtual {v1, v0}, Landroid/util/SparseIntArray;->get(I)I

    move-result v0

    .line 95
    .local v0, "currentFieldPosition":I
    iget-object v1, p0, Landroidx/versionedparcelable/c;->b:Landroid/os/Parcel;

    invoke-virtual {v1}, Landroid/os/Parcel;->dataPosition()I

    move-result v1

    .line 96
    .local v1, "position":I
    sub-int v2, v1, v0

    .line 101
    .local v2, "size":I
    iget-object v3, p0, Landroidx/versionedparcelable/c;->b:Landroid/os/Parcel;

    invoke-virtual {v3, v0}, Landroid/os/Parcel;->setDataPosition(I)V

    .line 102
    iget-object v3, p0, Landroidx/versionedparcelable/c;->b:Landroid/os/Parcel;

    invoke-virtual {v3, v2}, Landroid/os/Parcel;->writeInt(I)V

    .line 103
    iget-object v3, p0, Landroidx/versionedparcelable/c;->b:Landroid/os/Parcel;

    invoke-virtual {v3, v1}, Landroid/os/Parcel;->setDataPosition(I)V

    .line 105
    .end local v0    # "currentFieldPosition":I
    .end local v1    # "position":I
    .end local v2    # "size":I
    :cond_0
    return-void
.end method

.method public a(Landroid/os/Parcelable;)V
    .locals 2
    .param p1, "p"    # Landroid/os/Parcelable;

    .line 169
    iget-object v0, p0, Landroidx/versionedparcelable/c;->b:Landroid/os/Parcel;

    const/4 v1, 0x0

    invoke-virtual {v0, p1, v1}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 170
    return-void
.end method

.method public a(Ljava/lang/String;)V
    .locals 1
    .param p1, "val"    # Ljava/lang/String;

    .line 159
    iget-object v0, p0, Landroidx/versionedparcelable/c;->b:Landroid/os/Parcel;

    invoke-virtual {v0, p1}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 160
    return-void
.end method

.method public a([B)V
    .locals 2
    .param p1, "b"    # [B

    .line 119
    if-eqz p1, :cond_0

    .line 120
    iget-object v0, p0, Landroidx/versionedparcelable/c;->b:Landroid/os/Parcel;

    array-length v1, p1

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 121
    iget-object v0, p0, Landroidx/versionedparcelable/c;->b:Landroid/os/Parcel;

    invoke-virtual {v0, p1}, Landroid/os/Parcel;->writeByteArray([B)V

    goto :goto_0

    .line 123
    :cond_0
    iget-object v0, p0, Landroidx/versionedparcelable/c;->b:Landroid/os/Parcel;

    const/4 v1, -0x1

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 125
    :goto_0
    return-void
.end method

.method public a(I)Z
    .locals 2
    .param p1, "fieldId"    # I

    .line 72
    invoke-direct {p0, p1}, Landroidx/versionedparcelable/c;->d(I)I

    move-result v0

    .line 73
    .local v0, "position":I
    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    .line 74
    const/4 v1, 0x0

    return v1

    .line 77
    :cond_0
    iget-object v1, p0, Landroidx/versionedparcelable/c;->b:Landroid/os/Parcel;

    invoke-virtual {v1, v0}, Landroid/os/Parcel;->setDataPosition(I)V

    .line 78
    const/4 v1, 0x1

    return v1
.end method

.method protected b()Landroidx/versionedparcelable/b;
    .locals 6

    .line 113
    new-instance v0, Landroidx/versionedparcelable/c;

    iget-object v1, p0, Landroidx/versionedparcelable/c;->b:Landroid/os/Parcel;

    invoke-virtual {v1}, Landroid/os/Parcel;->dataPosition()I

    move-result v2

    iget v3, p0, Landroidx/versionedparcelable/c;->g:I

    iget v4, p0, Landroidx/versionedparcelable/c;->c:I

    if-ne v3, v4, :cond_0

    iget v3, p0, Landroidx/versionedparcelable/c;->d:I

    :cond_0
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v5, p0, Landroidx/versionedparcelable/c;->e:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v5, "  "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v0, v1, v2, v3, v4}, Landroidx/versionedparcelable/c;-><init>(Landroid/os/Parcel;IILjava/lang/String;)V

    return-object v0
.end method

.method public b(I)V
    .locals 2
    .param p1, "fieldId"    # I

    .line 83
    invoke-virtual {p0}, Landroidx/versionedparcelable/c;->a()V

    .line 84
    iput p1, p0, Landroidx/versionedparcelable/c;->f:I

    .line 85
    iget-object v0, p0, Landroidx/versionedparcelable/c;->a:Landroid/util/SparseIntArray;

    iget-object v1, p0, Landroidx/versionedparcelable/c;->b:Landroid/os/Parcel;

    invoke-virtual {v1}, Landroid/os/Parcel;->dataPosition()I

    move-result v1

    invoke-virtual {v0, p1, v1}, Landroid/util/SparseIntArray;->put(II)V

    .line 87
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Landroidx/versionedparcelable/c;->c(I)V

    .line 88
    invoke-virtual {p0, p1}, Landroidx/versionedparcelable/c;->c(I)V

    .line 89
    return-void
.end method

.method public c(I)V
    .locals 1
    .param p1, "val"    # I

    .line 139
    iget-object v0, p0, Landroidx/versionedparcelable/c;->b:Landroid/os/Parcel;

    invoke-virtual {v0, p1}, Landroid/os/Parcel;->writeInt(I)V

    .line 140
    return-void
.end method

.method public d()[B
    .locals 3

    .line 219
    iget-object v0, p0, Landroidx/versionedparcelable/c;->b:Landroid/os/Parcel;

    invoke-virtual {v0}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .line 220
    .local v0, "len":I
    if-gez v0, :cond_0

    .line 221
    const/4 v1, 0x0

    return-object v1

    .line 223
    :cond_0
    new-array v1, v0, [B

    .line 224
    .local v1, "bytes":[B
    iget-object v2, p0, Landroidx/versionedparcelable/c;->b:Landroid/os/Parcel;

    invoke-virtual {v2, v1}, Landroid/os/Parcel;->readByteArray([B)V

    .line 225
    return-object v1
.end method

.method public e()I
    .locals 1

    .line 189
    iget-object v0, p0, Landroidx/versionedparcelable/c;->b:Landroid/os/Parcel;

    invoke-virtual {v0}, Landroid/os/Parcel;->readInt()I

    move-result v0

    return v0
.end method

.method public f()Landroid/os/Parcelable;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T::",
            "Landroid/os/Parcelable;",
            ">()TT;"
        }
    .end annotation

    .line 231
    iget-object v0, p0, Landroidx/versionedparcelable/c;->b:Landroid/os/Parcel;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v0

    return-object v0
.end method

.method public g()Ljava/lang/String;
    .locals 1

    .line 209
    iget-object v0, p0, Landroidx/versionedparcelable/c;->b:Landroid/os/Parcel;

    invoke-virtual {v0}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
