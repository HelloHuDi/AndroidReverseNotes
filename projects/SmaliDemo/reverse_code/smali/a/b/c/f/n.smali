.class public La/b/c/f/n;
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

.field private c:[I

.field private d:[Ljava/lang/Object;

.field private e:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 51
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, La/b/c/f/n;->a:Ljava/lang/Object;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .line 62
    .local p0, "this":La/b/c/f/n;, "Landroid/support/v4/util/SparseArrayCompat<TE;>;"
    const/16 v0, 0xa

    invoke-direct {p0, v0}, La/b/c/f/n;-><init>(I)V

    .line 63
    return-void
.end method

.method public constructor <init>(I)V
    .locals 2
    .param p1, "initialCapacity"    # I

    .line 72
    .local p0, "this":La/b/c/f/n;, "Landroid/support/v4/util/SparseArrayCompat<TE;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 52
    const/4 v0, 0x0

    iput-boolean v0, p0, La/b/c/f/n;->b:Z

    .line 73
    if-nez p1, :cond_0

    .line 74
    sget-object v1, La/b/c/f/e;->a:[I

    iput-object v1, p0, La/b/c/f/n;->c:[I

    .line 75
    sget-object v1, La/b/c/f/e;->c:[Ljava/lang/Object;

    iput-object v1, p0, La/b/c/f/n;->d:[Ljava/lang/Object;

    goto :goto_0

    .line 77
    :cond_0
    invoke-static {p1}, La/b/c/f/e;->b(I)I

    move-result p1

    .line 78
    new-array v1, p1, [I

    iput-object v1, p0, La/b/c/f/n;->c:[I

    .line 79
    new-array v1, p1, [Ljava/lang/Object;

    iput-object v1, p0, La/b/c/f/n;->d:[Ljava/lang/Object;

    .line 81
    :goto_0
    iput v0, p0, La/b/c/f/n;->e:I

    .line 82
    return-void
.end method

.method private c()V
    .locals 7

    .line 175
    .local p0, "this":La/b/c/f/n;, "Landroid/support/v4/util/SparseArrayCompat<TE;>;"
    iget v0, p0, La/b/c/f/n;->e:I

    .line 176
    .local v0, "n":I
    const/4 v1, 0x0

    .line 177
    .local v1, "o":I
    iget-object v2, p0, La/b/c/f/n;->c:[I

    .line 178
    .local v2, "keys":[I
    iget-object v3, p0, La/b/c/f/n;->d:[Ljava/lang/Object;

    .line 180
    .local v3, "values":[Ljava/lang/Object;
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_0
    if-ge v4, v0, :cond_2

    .line 181
    aget-object v5, v3, v4

    .line 183
    .local v5, "val":Ljava/lang/Object;
    sget-object v6, La/b/c/f/n;->a:Ljava/lang/Object;

    if-eq v5, v6, :cond_1

    .line 184
    if-eq v4, v1, :cond_0

    .line 185
    aget v6, v2, v4

    aput v6, v2, v1

    .line 186
    aput-object v5, v3, v1

    .line 187
    const/4 v6, 0x0

    aput-object v6, v3, v4

    .line 190
    :cond_0
    add-int/lit8 v1, v1, 0x1

    .line 180
    .end local v5    # "val":Ljava/lang/Object;
    :cond_1
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 194
    .end local v4    # "i":I
    :cond_2
    const/4 v4, 0x0

    iput-boolean v4, p0, La/b/c/f/n;->b:Z

    .line 195
    iput v1, p0, La/b/c/f/n;->e:I

    .line 198
    return-void
.end method


# virtual methods
.method public a()V
    .locals 4

    .line 372
    .local p0, "this":La/b/c/f/n;, "Landroid/support/v4/util/SparseArrayCompat<TE;>;"
    iget v0, p0, La/b/c/f/n;->e:I

    .line 373
    .local v0, "n":I
    iget-object v1, p0, La/b/c/f/n;->d:[Ljava/lang/Object;

    .line 375
    .local v1, "values":[Ljava/lang/Object;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, v0, :cond_0

    .line 376
    const/4 v3, 0x0

    aput-object v3, v1, v2

    .line 375
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 379
    .end local v2    # "i":I
    :cond_0
    const/4 v2, 0x0

    iput v2, p0, La/b/c/f/n;->e:I

    .line 380
    iput-boolean v2, p0, La/b/c/f/n;->b:Z

    .line 381
    return-void
.end method

.method public a(I)V
    .locals 4
    .param p1, "key"    # I

    .line 132
    .local p0, "this":La/b/c/f/n;, "Landroid/support/v4/util/SparseArrayCompat<TE;>;"
    iget-object v0, p0, La/b/c/f/n;->c:[I

    iget v1, p0, La/b/c/f/n;->e:I

    invoke-static {v0, v1, p1}, La/b/c/f/e;->a([III)I

    move-result v0

    .line 134
    .local v0, "i":I
    if-ltz v0, :cond_0

    .line 135
    iget-object v1, p0, La/b/c/f/n;->d:[Ljava/lang/Object;

    aget-object v2, v1, v0

    sget-object v3, La/b/c/f/n;->a:Ljava/lang/Object;

    if-eq v2, v3, :cond_0

    .line 136
    aput-object v3, v1, v0

    .line 137
    const/4 v1, 0x1

    iput-boolean v1, p0, La/b/c/f/n;->b:Z

    .line 140
    :cond_0
    return-void
.end method

.method public a(ILjava/lang/Object;)V
    .locals 7
    .param p1, "key"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(ITE;)V"
        }
    .end annotation

    .line 388
    .local p0, "this":La/b/c/f/n;, "Landroid/support/v4/util/SparseArrayCompat<TE;>;"
    .local p2, "value":Ljava/lang/Object;, "TE;"
    iget v0, p0, La/b/c/f/n;->e:I

    if-eqz v0, :cond_0

    iget-object v1, p0, La/b/c/f/n;->c:[I

    add-int/lit8 v0, v0, -0x1

    aget v0, v1, v0

    if-gt p1, v0, :cond_0

    .line 389
    invoke-virtual {p0, p1, p2}, La/b/c/f/n;->c(ILjava/lang/Object;)V

    .line 390
    return-void

    .line 393
    :cond_0
    iget-boolean v0, p0, La/b/c/f/n;->b:Z

    if-eqz v0, :cond_1

    iget v0, p0, La/b/c/f/n;->e:I

    iget-object v1, p0, La/b/c/f/n;->c:[I

    array-length v1, v1

    if-lt v0, v1, :cond_1

    .line 394
    invoke-direct {p0}, La/b/c/f/n;->c()V

    .line 397
    :cond_1
    iget v0, p0, La/b/c/f/n;->e:I

    .line 398
    .local v0, "pos":I
    iget-object v1, p0, La/b/c/f/n;->c:[I

    array-length v1, v1

    if-lt v0, v1, :cond_2

    .line 399
    add-int/lit8 v1, v0, 0x1

    invoke-static {v1}, La/b/c/f/e;->b(I)I

    move-result v1

    .line 401
    .local v1, "n":I
    new-array v2, v1, [I

    .line 402
    .local v2, "nkeys":[I
    new-array v3, v1, [Ljava/lang/Object;

    .line 405
    .local v3, "nvalues":[Ljava/lang/Object;
    iget-object v4, p0, La/b/c/f/n;->c:[I

    array-length v5, v4

    const/4 v6, 0x0

    invoke-static {v4, v6, v2, v6, v5}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 406
    iget-object v4, p0, La/b/c/f/n;->d:[Ljava/lang/Object;

    array-length v5, v4

    invoke-static {v4, v6, v3, v6, v5}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 408
    iput-object v2, p0, La/b/c/f/n;->c:[I

    .line 409
    iput-object v3, p0, La/b/c/f/n;->d:[Ljava/lang/Object;

    .line 412
    .end local v1    # "n":I
    .end local v2    # "nkeys":[I
    .end local v3    # "nvalues":[Ljava/lang/Object;
    :cond_2
    iget-object v1, p0, La/b/c/f/n;->c:[I

    aput p1, v1, v0

    .line 413
    iget-object v1, p0, La/b/c/f/n;->d:[Ljava/lang/Object;

    aput-object p2, v1, v0

    .line 414
    add-int/lit8 v1, v0, 0x1

    iput v1, p0, La/b/c/f/n;->e:I

    .line 415
    return-void
.end method

.method public b()I
    .locals 1

    .line 268
    .local p0, "this":La/b/c/f/n;, "Landroid/support/v4/util/SparseArrayCompat<TE;>;"
    iget-boolean v0, p0, La/b/c/f/n;->b:Z

    if-eqz v0, :cond_0

    .line 269
    invoke-direct {p0}, La/b/c/f/n;->c()V

    .line 272
    :cond_0
    iget v0, p0, La/b/c/f/n;->e:I

    return v0
.end method

.method public b(I)Ljava/lang/Object;
    .locals 1
    .param p1, "key"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)TE;"
        }
    .end annotation

    .line 110
    .local p0, "this":La/b/c/f/n;, "Landroid/support/v4/util/SparseArrayCompat<TE;>;"
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, La/b/c/f/n;->b(ILjava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public b(ILjava/lang/Object;)Ljava/lang/Object;
    .locals 4
    .param p1, "key"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(ITE;)TE;"
        }
    .end annotation

    .line 119
    .local p0, "this":La/b/c/f/n;, "Landroid/support/v4/util/SparseArrayCompat<TE;>;"
    .local p2, "valueIfKeyNotFound":Ljava/lang/Object;, "TE;"
    iget-object v0, p0, La/b/c/f/n;->c:[I

    iget v1, p0, La/b/c/f/n;->e:I

    invoke-static {v0, v1, p1}, La/b/c/f/e;->a([III)I

    move-result v0

    .line 121
    .local v0, "i":I
    if-ltz v0, :cond_1

    iget-object v1, p0, La/b/c/f/n;->d:[Ljava/lang/Object;

    aget-object v2, v1, v0

    sget-object v3, La/b/c/f/n;->a:Ljava/lang/Object;

    if-ne v2, v3, :cond_0

    goto :goto_0

    .line 124
    :cond_0
    aget-object v1, v1, v0

    return-object v1

    .line 122
    :cond_1
    :goto_0
    return-object p2
.end method

.method public c(I)I
    .locals 1
    .param p1, "index"    # I

    .line 289
    .local p0, "this":La/b/c/f/n;, "Landroid/support/v4/util/SparseArrayCompat<TE;>;"
    iget-boolean v0, p0, La/b/c/f/n;->b:Z

    if-eqz v0, :cond_0

    .line 290
    invoke-direct {p0}, La/b/c/f/n;->c()V

    .line 293
    :cond_0
    iget-object v0, p0, La/b/c/f/n;->c:[I

    aget v0, v0, p1

    return v0
.end method

.method public c(ILjava/lang/Object;)V
    .locals 7
    .param p1, "key"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(ITE;)V"
        }
    .end annotation

    .line 206
    .local p0, "this":La/b/c/f/n;, "Landroid/support/v4/util/SparseArrayCompat<TE;>;"
    .local p2, "value":Ljava/lang/Object;, "TE;"
    iget-object v0, p0, La/b/c/f/n;->c:[I

    iget v1, p0, La/b/c/f/n;->e:I

    invoke-static {v0, v1, p1}, La/b/c/f/e;->a([III)I

    move-result v0

    .line 208
    .local v0, "i":I
    if-ltz v0, :cond_0

    .line 209
    iget-object v1, p0, La/b/c/f/n;->d:[Ljava/lang/Object;

    aput-object p2, v1, v0

    goto :goto_0

    .line 211
    :cond_0
    xor-int/lit8 v0, v0, -0x1

    .line 213
    iget v1, p0, La/b/c/f/n;->e:I

    if-ge v0, v1, :cond_1

    iget-object v1, p0, La/b/c/f/n;->d:[Ljava/lang/Object;

    aget-object v2, v1, v0

    sget-object v3, La/b/c/f/n;->a:Ljava/lang/Object;

    if-ne v2, v3, :cond_1

    .line 214
    iget-object v2, p0, La/b/c/f/n;->c:[I

    aput p1, v2, v0

    .line 215
    aput-object p2, v1, v0

    .line 216
    return-void

    .line 219
    :cond_1
    iget-boolean v1, p0, La/b/c/f/n;->b:Z

    if-eqz v1, :cond_2

    iget v1, p0, La/b/c/f/n;->e:I

    iget-object v2, p0, La/b/c/f/n;->c:[I

    array-length v2, v2

    if-lt v1, v2, :cond_2

    .line 220
    invoke-direct {p0}, La/b/c/f/n;->c()V

    .line 223
    iget-object v1, p0, La/b/c/f/n;->c:[I

    iget v2, p0, La/b/c/f/n;->e:I

    invoke-static {v1, v2, p1}, La/b/c/f/e;->a([III)I

    move-result v1

    xor-int/lit8 v0, v1, -0x1

    .line 226
    :cond_2
    iget v1, p0, La/b/c/f/n;->e:I

    iget-object v2, p0, La/b/c/f/n;->c:[I

    array-length v2, v2

    if-lt v1, v2, :cond_3

    .line 227
    add-int/lit8 v1, v1, 0x1

    invoke-static {v1}, La/b/c/f/e;->b(I)I

    move-result v1

    .line 229
    .local v1, "n":I
    new-array v2, v1, [I

    .line 230
    .local v2, "nkeys":[I
    new-array v3, v1, [Ljava/lang/Object;

    .line 233
    .local v3, "nvalues":[Ljava/lang/Object;
    iget-object v4, p0, La/b/c/f/n;->c:[I

    array-length v5, v4

    const/4 v6, 0x0

    invoke-static {v4, v6, v2, v6, v5}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 234
    iget-object v4, p0, La/b/c/f/n;->d:[Ljava/lang/Object;

    array-length v5, v4

    invoke-static {v4, v6, v3, v6, v5}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 236
    iput-object v2, p0, La/b/c/f/n;->c:[I

    .line 237
    iput-object v3, p0, La/b/c/f/n;->d:[Ljava/lang/Object;

    .line 240
    .end local v1    # "n":I
    .end local v2    # "nkeys":[I
    .end local v3    # "nvalues":[Ljava/lang/Object;
    :cond_3
    iget v1, p0, La/b/c/f/n;->e:I

    sub-int v2, v1, v0

    if-eqz v2, :cond_4

    .line 242
    iget-object v2, p0, La/b/c/f/n;->c:[I

    add-int/lit8 v3, v0, 0x1

    sub-int/2addr v1, v0

    invoke-static {v2, v0, v2, v3, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 243
    iget-object v1, p0, La/b/c/f/n;->d:[Ljava/lang/Object;

    add-int/lit8 v2, v0, 0x1

    iget v3, p0, La/b/c/f/n;->e:I

    sub-int/2addr v3, v0

    invoke-static {v1, v0, v1, v2, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 246
    :cond_4
    iget-object v1, p0, La/b/c/f/n;->c:[I

    aput p1, v1, v0

    .line 247
    iget-object v1, p0, La/b/c/f/n;->d:[Ljava/lang/Object;

    aput-object p2, v1, v0

    .line 248
    iget v1, p0, La/b/c/f/n;->e:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, La/b/c/f/n;->e:I

    .line 250
    :goto_0
    return-void
.end method

.method public clone()La/b/c/f/n;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "La/b/c/f/n<",
            "TE;>;"
        }
    .end annotation

    .line 89
    .local p0, "this":La/b/c/f/n;, "Landroid/support/v4/util/SparseArrayCompat<TE;>;"
    :try_start_0
    invoke-super {p0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, La/b/c/f/n;

    .line 90
    .local v0, "clone":La/b/c/f/n;, "Landroid/support/v4/util/SparseArrayCompat<TE;>;"
    iget-object v1, p0, La/b/c/f/n;->c:[I

    invoke-virtual {v1}, [I->clone()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [I

    iput-object v1, v0, La/b/c/f/n;->c:[I

    .line 91
    iget-object v1, p0, La/b/c/f/n;->d:[Ljava/lang/Object;

    invoke-virtual {v1}, [Ljava/lang/Object;->clone()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Ljava/lang/Object;

    iput-object v1, v0, La/b/c/f/n;->d:[Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/CloneNotSupportedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 94
    nop

    .line 95
    return-object v0

    .line 92
    .end local v0    # "clone":La/b/c/f/n;, "Landroid/support/v4/util/SparseArrayCompat<TE;>;"
    :catch_0
    move-exception v0

    .line 93
    .local v0, "e":Ljava/lang/CloneNotSupportedException;
    new-instance v1, Ljava/lang/AssertionError;

    invoke-direct {v1, v0}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    throw v1
.end method

.method public bridge synthetic clone()Ljava/lang/Object;
    .locals 1

    .line 50
    .local p0, "this":La/b/c/f/n;, "Landroid/support/v4/util/SparseArrayCompat<TE;>;"
    invoke-virtual {p0}, La/b/c/f/n;->clone()La/b/c/f/n;

    move-result-object v0

    return-object v0
.end method

.method public d(I)V
    .locals 0
    .param p1, "key"    # I

    .line 146
    .local p0, "this":La/b/c/f/n;, "Landroid/support/v4/util/SparseArrayCompat<TE;>;"
    invoke-virtual {p0, p1}, La/b/c/f/n;->a(I)V

    .line 147
    return-void
.end method

.method public e(I)Ljava/lang/Object;
    .locals 1
    .param p1, "index"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)TE;"
        }
    .end annotation

    .line 303
    .local p0, "this":La/b/c/f/n;, "Landroid/support/v4/util/SparseArrayCompat<TE;>;"
    iget-boolean v0, p0, La/b/c/f/n;->b:Z

    if-eqz v0, :cond_0

    .line 304
    invoke-direct {p0}, La/b/c/f/n;->c()V

    .line 307
    :cond_0
    iget-object v0, p0, La/b/c/f/n;->d:[Ljava/lang/Object;

    aget-object v0, v0, p1

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 5

    .line 426
    .local p0, "this":La/b/c/f/n;, "Landroid/support/v4/util/SparseArrayCompat<TE;>;"
    invoke-virtual {p0}, La/b/c/f/n;->b()I

    move-result v0

    if-gtz v0, :cond_0

    .line 427
    const-string v0, "{}"

    return-object v0

    .line 430
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    iget v1, p0, La/b/c/f/n;->e:I

    mul-int/lit8 v1, v1, 0x1c

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 431
    .local v0, "buffer":Ljava/lang/StringBuilder;
    const/16 v1, 0x7b

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 432
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget v2, p0, La/b/c/f/n;->e:I

    if-ge v1, v2, :cond_3

    .line 433
    if-lez v1, :cond_1

    .line 434
    const-string v2, ", "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 436
    :cond_1
    invoke-virtual {p0, v1}, La/b/c/f/n;->c(I)I

    move-result v2

    .line 437
    .local v2, "key":I
    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 438
    const/16 v3, 0x3d

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 439
    invoke-virtual {p0, v1}, La/b/c/f/n;->e(I)Ljava/lang/Object;

    move-result-object v3

    .line 440
    .local v3, "value":Ljava/lang/Object;
    if-eq v3, p0, :cond_2

    .line 441
    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 443
    :cond_2
    const-string v4, "(this Map)"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 432
    .end local v2    # "key":I
    .end local v3    # "value":Ljava/lang/Object;
    :goto_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 446
    .end local v1    # "i":I
    :cond_3
    const/16 v1, 0x7d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 447
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
