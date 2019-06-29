.class public La/b/c/f/h;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Ljava/lang/Cloneable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<E:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Ljava/lang/Cloneable;"
    }
.end annotation


# static fields
.field private static final a:Ljava/lang/Object;


# instance fields
.field private b:Z

.field private c:[J

.field private d:[Ljava/lang/Object;

.field private e:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 47
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, La/b/c/f/h;->a:Ljava/lang/Object;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .line 58
    .local p0, "this":La/b/c/f/h;, "Landroid/support/v4/util/LongSparseArray<TE;>;"
    const/16 v0, 0xa

    invoke-direct {p0, v0}, La/b/c/f/h;-><init>(I)V

    .line 59
    return-void
.end method

.method public constructor <init>(I)V
    .locals 2
    .param p1, "initialCapacity"    # I

    .line 68
    .local p0, "this":La/b/c/f/h;, "Landroid/support/v4/util/LongSparseArray<TE;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 48
    const/4 v0, 0x0

    iput-boolean v0, p0, La/b/c/f/h;->b:Z

    .line 69
    if-nez p1, :cond_0

    .line 70
    sget-object v1, La/b/c/f/e;->b:[J

    iput-object v1, p0, La/b/c/f/h;->c:[J

    .line 71
    sget-object v1, La/b/c/f/e;->c:[Ljava/lang/Object;

    iput-object v1, p0, La/b/c/f/h;->d:[Ljava/lang/Object;

    goto :goto_0

    .line 73
    :cond_0
    invoke-static {p1}, La/b/c/f/e;->c(I)I

    move-result p1

    .line 74
    new-array v1, p1, [J

    iput-object v1, p0, La/b/c/f/h;->c:[J

    .line 75
    new-array v1, p1, [Ljava/lang/Object;

    iput-object v1, p0, La/b/c/f/h;->d:[Ljava/lang/Object;

    .line 77
    :goto_0
    iput v0, p0, La/b/c/f/h;->e:I

    .line 78
    return-void
.end method

.method private c()V
    .locals 8

    .line 158
    .local p0, "this":La/b/c/f/h;, "Landroid/support/v4/util/LongSparseArray<TE;>;"
    iget v0, p0, La/b/c/f/h;->e:I

    .line 159
    .local v0, "n":I
    const/4 v1, 0x0

    .line 160
    .local v1, "o":I
    iget-object v2, p0, La/b/c/f/h;->c:[J

    .line 161
    .local v2, "keys":[J
    iget-object v3, p0, La/b/c/f/h;->d:[Ljava/lang/Object;

    .line 163
    .local v3, "values":[Ljava/lang/Object;
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_0
    if-ge v4, v0, :cond_2

    .line 164
    aget-object v5, v3, v4

    .line 166
    .local v5, "val":Ljava/lang/Object;
    sget-object v6, La/b/c/f/h;->a:Ljava/lang/Object;

    if-eq v5, v6, :cond_1

    .line 167
    if-eq v4, v1, :cond_0

    .line 168
    aget-wide v6, v2, v4

    aput-wide v6, v2, v1

    .line 169
    aput-object v5, v3, v1

    .line 170
    const/4 v6, 0x0

    aput-object v6, v3, v4

    .line 173
    :cond_0
    add-int/lit8 v1, v1, 0x1

    .line 163
    .end local v5    # "val":Ljava/lang/Object;
    :cond_1
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 177
    .end local v4    # "i":I
    :cond_2
    const/4 v4, 0x0

    iput-boolean v4, p0, La/b/c/f/h;->b:Z

    .line 178
    iput v1, p0, La/b/c/f/h;->e:I

    .line 181
    return-void
.end method


# virtual methods
.method public a(I)J
    .locals 3
    .param p1, "index"    # I

    .line 272
    .local p0, "this":La/b/c/f/h;, "Landroid/support/v4/util/LongSparseArray<TE;>;"
    iget-boolean v0, p0, La/b/c/f/h;->b:Z

    if-eqz v0, :cond_0

    .line 273
    invoke-direct {p0}, La/b/c/f/h;->c()V

    .line 276
    :cond_0
    iget-object v0, p0, La/b/c/f/h;->c:[J

    aget-wide v1, v0, p1

    return-wide v1
.end method

.method public a()V
    .locals 4

    .line 353
    .local p0, "this":La/b/c/f/h;, "Landroid/support/v4/util/LongSparseArray<TE;>;"
    iget v0, p0, La/b/c/f/h;->e:I

    .line 354
    .local v0, "n":I
    iget-object v1, p0, La/b/c/f/h;->d:[Ljava/lang/Object;

    .line 356
    .local v1, "values":[Ljava/lang/Object;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, v0, :cond_0

    .line 357
    const/4 v3, 0x0

    aput-object v3, v1, v2

    .line 356
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 360
    .end local v2    # "i":I
    :cond_0
    const/4 v2, 0x0

    iput v2, p0, La/b/c/f/h;->e:I

    .line 361
    iput-boolean v2, p0, La/b/c/f/h;->b:Z

    .line 362
    return-void
.end method

.method public a(J)V
    .locals 4
    .param p1, "key"    # J

    .line 128
    .local p0, "this":La/b/c/f/h;, "Landroid/support/v4/util/LongSparseArray<TE;>;"
    iget-object v0, p0, La/b/c/f/h;->c:[J

    iget v1, p0, La/b/c/f/h;->e:I

    invoke-static {v0, v1, p1, p2}, La/b/c/f/e;->a([JIJ)I

    move-result v0

    .line 130
    .local v0, "i":I
    if-ltz v0, :cond_0

    .line 131
    iget-object v1, p0, La/b/c/f/h;->d:[Ljava/lang/Object;

    aget-object v2, v1, v0

    sget-object v3, La/b/c/f/h;->a:Ljava/lang/Object;

    if-eq v2, v3, :cond_0

    .line 132
    aput-object v3, v1, v0

    .line 133
    const/4 v1, 0x1

    iput-boolean v1, p0, La/b/c/f/h;->b:Z

    .line 136
    :cond_0
    return-void
.end method

.method public a(JLjava/lang/Object;)V
    .locals 7
    .param p1, "key"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(JTE;)V"
        }
    .end annotation

    .line 369
    .local p0, "this":La/b/c/f/h;, "Landroid/support/v4/util/LongSparseArray<TE;>;"
    .local p3, "value":Ljava/lang/Object;, "TE;"
    iget v0, p0, La/b/c/f/h;->e:I

    if-eqz v0, :cond_0

    iget-object v1, p0, La/b/c/f/h;->c:[J

    add-int/lit8 v0, v0, -0x1

    aget-wide v0, v1, v0

    cmp-long v2, p1, v0

    if-gtz v2, :cond_0

    .line 370
    invoke-virtual {p0, p1, p2, p3}, La/b/c/f/h;->c(JLjava/lang/Object;)V

    .line 371
    return-void

    .line 374
    :cond_0
    iget-boolean v0, p0, La/b/c/f/h;->b:Z

    if-eqz v0, :cond_1

    iget v0, p0, La/b/c/f/h;->e:I

    iget-object v1, p0, La/b/c/f/h;->c:[J

    array-length v1, v1

    if-lt v0, v1, :cond_1

    .line 375
    invoke-direct {p0}, La/b/c/f/h;->c()V

    .line 378
    :cond_1
    iget v0, p0, La/b/c/f/h;->e:I

    .line 379
    .local v0, "pos":I
    iget-object v1, p0, La/b/c/f/h;->c:[J

    array-length v1, v1

    if-lt v0, v1, :cond_2

    .line 380
    add-int/lit8 v1, v0, 0x1

    invoke-static {v1}, La/b/c/f/e;->c(I)I

    move-result v1

    .line 382
    .local v1, "n":I
    new-array v2, v1, [J

    .line 383
    .local v2, "nkeys":[J
    new-array v3, v1, [Ljava/lang/Object;

    .line 386
    .local v3, "nvalues":[Ljava/lang/Object;
    iget-object v4, p0, La/b/c/f/h;->c:[J

    array-length v5, v4

    const/4 v6, 0x0

    invoke-static {v4, v6, v2, v6, v5}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 387
    iget-object v4, p0, La/b/c/f/h;->d:[Ljava/lang/Object;

    array-length v5, v4

    invoke-static {v4, v6, v3, v6, v5}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 389
    iput-object v2, p0, La/b/c/f/h;->c:[J

    .line 390
    iput-object v3, p0, La/b/c/f/h;->d:[Ljava/lang/Object;

    .line 393
    .end local v1    # "n":I
    .end local v2    # "nkeys":[J
    .end local v3    # "nvalues":[Ljava/lang/Object;
    :cond_2
    iget-object v1, p0, La/b/c/f/h;->c:[J

    aput-wide p1, v1, v0

    .line 394
    iget-object v1, p0, La/b/c/f/h;->d:[Ljava/lang/Object;

    aput-object p3, v1, v0

    .line 395
    add-int/lit8 v1, v0, 0x1

    iput v1, p0, La/b/c/f/h;->e:I

    .line 396
    return-void
.end method

.method public b()I
    .locals 1

    .line 251
    .local p0, "this":La/b/c/f/h;, "Landroid/support/v4/util/LongSparseArray<TE;>;"
    iget-boolean v0, p0, La/b/c/f/h;->b:Z

    if-eqz v0, :cond_0

    .line 252
    invoke-direct {p0}, La/b/c/f/h;->c()V

    .line 255
    :cond_0
    iget v0, p0, La/b/c/f/h;->e:I

    return v0
.end method

.method public b(I)Ljava/lang/Object;
    .locals 1
    .param p1, "index"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)TE;"
        }
    .end annotation

    .line 286
    .local p0, "this":La/b/c/f/h;, "Landroid/support/v4/util/LongSparseArray<TE;>;"
    iget-boolean v0, p0, La/b/c/f/h;->b:Z

    if-eqz v0, :cond_0

    .line 287
    invoke-direct {p0}, La/b/c/f/h;->c()V

    .line 290
    :cond_0
    iget-object v0, p0, La/b/c/f/h;->d:[Ljava/lang/Object;

    aget-object v0, v0, p1

    return-object v0
.end method

.method public b(J)Ljava/lang/Object;
    .locals 1
    .param p1, "key"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(J)TE;"
        }
    .end annotation

    .line 106
    .local p0, "this":La/b/c/f/h;, "Landroid/support/v4/util/LongSparseArray<TE;>;"
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, v0}, La/b/c/f/h;->b(JLjava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public b(JLjava/lang/Object;)Ljava/lang/Object;
    .locals 4
    .param p1, "key"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(JTE;)TE;"
        }
    .end annotation

    .line 115
    .local p0, "this":La/b/c/f/h;, "Landroid/support/v4/util/LongSparseArray<TE;>;"
    .local p3, "valueIfKeyNotFound":Ljava/lang/Object;, "TE;"
    iget-object v0, p0, La/b/c/f/h;->c:[J

    iget v1, p0, La/b/c/f/h;->e:I

    invoke-static {v0, v1, p1, p2}, La/b/c/f/e;->a([JIJ)I

    move-result v0

    .line 117
    .local v0, "i":I
    if-ltz v0, :cond_1

    iget-object v1, p0, La/b/c/f/h;->d:[Ljava/lang/Object;

    aget-object v2, v1, v0

    sget-object v3, La/b/c/f/h;->a:Ljava/lang/Object;

    if-ne v2, v3, :cond_0

    goto :goto_0

    .line 120
    :cond_0
    aget-object v1, v1, v0

    return-object v1

    .line 118
    :cond_1
    :goto_0
    return-object p3
.end method

.method public c(JLjava/lang/Object;)V
    .locals 7
    .param p1, "key"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(JTE;)V"
        }
    .end annotation

    .line 189
    .local p0, "this":La/b/c/f/h;, "Landroid/support/v4/util/LongSparseArray<TE;>;"
    .local p3, "value":Ljava/lang/Object;, "TE;"
    iget-object v0, p0, La/b/c/f/h;->c:[J

    iget v1, p0, La/b/c/f/h;->e:I

    invoke-static {v0, v1, p1, p2}, La/b/c/f/e;->a([JIJ)I

    move-result v0

    .line 191
    .local v0, "i":I
    if-ltz v0, :cond_0

    .line 192
    iget-object v1, p0, La/b/c/f/h;->d:[Ljava/lang/Object;

    aput-object p3, v1, v0

    goto :goto_0

    .line 194
    :cond_0
    xor-int/lit8 v0, v0, -0x1

    .line 196
    iget v1, p0, La/b/c/f/h;->e:I

    if-ge v0, v1, :cond_1

    iget-object v1, p0, La/b/c/f/h;->d:[Ljava/lang/Object;

    aget-object v2, v1, v0

    sget-object v3, La/b/c/f/h;->a:Ljava/lang/Object;

    if-ne v2, v3, :cond_1

    .line 197
    iget-object v2, p0, La/b/c/f/h;->c:[J

    aput-wide p1, v2, v0

    .line 198
    aput-object p3, v1, v0

    .line 199
    return-void

    .line 202
    :cond_1
    iget-boolean v1, p0, La/b/c/f/h;->b:Z

    if-eqz v1, :cond_2

    iget v1, p0, La/b/c/f/h;->e:I

    iget-object v2, p0, La/b/c/f/h;->c:[J

    array-length v2, v2

    if-lt v1, v2, :cond_2

    .line 203
    invoke-direct {p0}, La/b/c/f/h;->c()V

    .line 206
    iget-object v1, p0, La/b/c/f/h;->c:[J

    iget v2, p0, La/b/c/f/h;->e:I

    invoke-static {v1, v2, p1, p2}, La/b/c/f/e;->a([JIJ)I

    move-result v1

    xor-int/lit8 v0, v1, -0x1

    .line 209
    :cond_2
    iget v1, p0, La/b/c/f/h;->e:I

    iget-object v2, p0, La/b/c/f/h;->c:[J

    array-length v2, v2

    if-lt v1, v2, :cond_3

    .line 210
    add-int/lit8 v1, v1, 0x1

    invoke-static {v1}, La/b/c/f/e;->c(I)I

    move-result v1

    .line 212
    .local v1, "n":I
    new-array v2, v1, [J

    .line 213
    .local v2, "nkeys":[J
    new-array v3, v1, [Ljava/lang/Object;

    .line 216
    .local v3, "nvalues":[Ljava/lang/Object;
    iget-object v4, p0, La/b/c/f/h;->c:[J

    array-length v5, v4

    const/4 v6, 0x0

    invoke-static {v4, v6, v2, v6, v5}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 217
    iget-object v4, p0, La/b/c/f/h;->d:[Ljava/lang/Object;

    array-length v5, v4

    invoke-static {v4, v6, v3, v6, v5}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 219
    iput-object v2, p0, La/b/c/f/h;->c:[J

    .line 220
    iput-object v3, p0, La/b/c/f/h;->d:[Ljava/lang/Object;

    .line 223
    .end local v1    # "n":I
    .end local v2    # "nkeys":[J
    .end local v3    # "nvalues":[Ljava/lang/Object;
    :cond_3
    iget v1, p0, La/b/c/f/h;->e:I

    sub-int v2, v1, v0

    if-eqz v2, :cond_4

    .line 225
    iget-object v2, p0, La/b/c/f/h;->c:[J

    add-int/lit8 v3, v0, 0x1

    sub-int/2addr v1, v0

    invoke-static {v2, v0, v2, v3, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 226
    iget-object v1, p0, La/b/c/f/h;->d:[Ljava/lang/Object;

    add-int/lit8 v2, v0, 0x1

    iget v3, p0, La/b/c/f/h;->e:I

    sub-int/2addr v3, v0

    invoke-static {v1, v0, v1, v2, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 229
    :cond_4
    iget-object v1, p0, La/b/c/f/h;->c:[J

    aput-wide p1, v1, v0

    .line 230
    iget-object v1, p0, La/b/c/f/h;->d:[Ljava/lang/Object;

    aput-object p3, v1, v0

    .line 231
    iget v1, p0, La/b/c/f/h;->e:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, La/b/c/f/h;->e:I

    .line 233
    :goto_0
    return-void
.end method

.method public clone()La/b/c/f/h;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "La/b/c/f/h<",
            "TE;>;"
        }
    .end annotation

    .line 85
    .local p0, "this":La/b/c/f/h;, "Landroid/support/v4/util/LongSparseArray<TE;>;"
    :try_start_0
    invoke-super {p0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, La/b/c/f/h;

    .line 86
    .local v0, "clone":La/b/c/f/h;, "Landroid/support/v4/util/LongSparseArray<TE;>;"
    iget-object v1, p0, La/b/c/f/h;->c:[J

    invoke-virtual {v1}, [J->clone()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [J

    iput-object v1, v0, La/b/c/f/h;->c:[J

    .line 87
    iget-object v1, p0, La/b/c/f/h;->d:[Ljava/lang/Object;

    invoke-virtual {v1}, [Ljava/lang/Object;->clone()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Ljava/lang/Object;

    iput-object v1, v0, La/b/c/f/h;->d:[Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/CloneNotSupportedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 90
    nop

    .line 91
    return-object v0

    .line 88
    .end local v0    # "clone":La/b/c/f/h;, "Landroid/support/v4/util/LongSparseArray<TE;>;"
    :catch_0
    move-exception v0

    .line 89
    .local v0, "e":Ljava/lang/CloneNotSupportedException;
    new-instance v1, Ljava/lang/AssertionError;

    invoke-direct {v1, v0}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    throw v1
.end method

.method public bridge synthetic clone()Ljava/lang/Object;
    .locals 1

    .line 46
    .local p0, "this":La/b/c/f/h;, "Landroid/support/v4/util/LongSparseArray<TE;>;"
    invoke-virtual {p0}, La/b/c/f/h;->clone()La/b/c/f/h;

    move-result-object v0

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 6

    .line 407
    .local p0, "this":La/b/c/f/h;, "Landroid/support/v4/util/LongSparseArray<TE;>;"
    invoke-virtual {p0}, La/b/c/f/h;->b()I

    move-result v0

    if-gtz v0, :cond_0

    .line 408
    const-string v0, "{}"

    return-object v0

    .line 411
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    iget v1, p0, La/b/c/f/h;->e:I

    mul-int/lit8 v1, v1, 0x1c

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 412
    .local v0, "buffer":Ljava/lang/StringBuilder;
    const/16 v1, 0x7b

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 413
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget v2, p0, La/b/c/f/h;->e:I

    if-ge v1, v2, :cond_3

    .line 414
    if-lez v1, :cond_1

    .line 415
    const-string v2, ", "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 417
    :cond_1
    invoke-virtual {p0, v1}, La/b/c/f/h;->a(I)J

    move-result-wide v2

    .line 418
    .local v2, "key":J
    invoke-virtual {v0, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    .line 419
    const/16 v4, 0x3d

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 420
    invoke-virtual {p0, v1}, La/b/c/f/h;->b(I)Ljava/lang/Object;

    move-result-object v4

    .line 421
    .local v4, "value":Ljava/lang/Object;
    if-eq v4, p0, :cond_2

    .line 422
    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 424
    :cond_2
    const-string v5, "(this Map)"

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 413
    .end local v2    # "key":J
    .end local v4    # "value":Ljava/lang/Object;
    :goto_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 427
    .end local v1    # "i":I
    :cond_3
    const/16 v1, 0x7d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 428
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
