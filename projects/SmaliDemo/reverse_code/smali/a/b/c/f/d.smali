.class public final La/b/c/f/d;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Ljava/util/Collection;
.implements Ljava/util/Set;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<E:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Ljava/util/Collection<",
        "TE;>;",
        "Ljava/util/Set<",
        "TE;>;"
    }
.end annotation


# static fields
.field private static final a:[I

.field private static final b:[Ljava/lang/Object;

.field private static c:[Ljava/lang/Object;

.field private static d:I

.field private static e:[Ljava/lang/Object;

.field private static f:I


# instance fields
.field private g:[I

.field h:[Ljava/lang/Object;

.field i:I

.field private j:La/b/c/f/j;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "La/b/c/f/j<",
            "TE;TE;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 53
    const/4 v0, 0x0

    new-array v1, v0, [I

    sput-object v1, La/b/c/f/d;->a:[I

    .line 54
    new-array v0, v0, [Ljava/lang/Object;

    sput-object v0, La/b/c/f/d;->b:[Ljava/lang/Object;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .line 243
    .local p0, "this":La/b/c/f/d;, "Landroid/support/v4/util/ArraySet<TE;>;"
    const/4 v0, 0x0

    invoke-direct {p0, v0}, La/b/c/f/d;-><init>(I)V

    .line 244
    return-void
.end method

.method public constructor <init>(I)V
    .locals 1
    .param p1, "capacity"    # I

    .line 250
    .local p0, "this":La/b/c/f/d;, "Landroid/support/v4/util/ArraySet<TE;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 251
    if-nez p1, :cond_0

    .line 252
    sget-object v0, La/b/c/f/d;->a:[I

    iput-object v0, p0, La/b/c/f/d;->g:[I

    .line 253
    sget-object v0, La/b/c/f/d;->b:[Ljava/lang/Object;

    iput-object v0, p0, La/b/c/f/d;->h:[Ljava/lang/Object;

    goto :goto_0

    .line 255
    :cond_0
    invoke-direct {p0, p1}, La/b/c/f/d;->d(I)V

    .line 257
    :goto_0
    const/4 v0, 0x0

    iput v0, p0, La/b/c/f/d;->i:I

    .line 258
    return-void
.end method

.method private a(Ljava/lang/Object;I)I
    .locals 5
    .param p1, "key"    # Ljava/lang/Object;
    .param p2, "hash"    # I

    .line 86
    .local p0, "this":La/b/c/f/d;, "Landroid/support/v4/util/ArraySet<TE;>;"
    iget v0, p0, La/b/c/f/d;->i:I

    .line 89
    .local v0, "N":I
    if-nez v0, :cond_0

    .line 90
    const/4 v1, -0x1

    return v1

    .line 93
    :cond_0
    iget-object v1, p0, La/b/c/f/d;->g:[I

    invoke-static {v1, v0, p2}, La/b/c/f/e;->a([III)I

    move-result v1

    .line 96
    .local v1, "index":I
    if-gez v1, :cond_1

    .line 97
    return v1

    .line 101
    :cond_1
    iget-object v2, p0, La/b/c/f/d;->h:[Ljava/lang/Object;

    aget-object v2, v2, v1

    invoke-virtual {p1, v2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 102
    return v1

    .line 107
    :cond_2
    add-int/lit8 v2, v1, 0x1

    .local v2, "end":I
    :goto_0
    if-ge v2, v0, :cond_4

    iget-object v3, p0, La/b/c/f/d;->g:[I

    aget v3, v3, v2

    if-ne v3, p2, :cond_4

    .line 108
    iget-object v3, p0, La/b/c/f/d;->h:[Ljava/lang/Object;

    aget-object v3, v3, v2

    invoke-virtual {p1, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    return v2

    .line 107
    :cond_3
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 112
    :cond_4
    add-int/lit8 v3, v1, -0x1

    .local v3, "i":I
    :goto_1
    if-ltz v3, :cond_6

    iget-object v4, p0, La/b/c/f/d;->g:[I

    aget v4, v4, v3

    if-ne v4, p2, :cond_6

    .line 113
    iget-object v4, p0, La/b/c/f/d;->h:[Ljava/lang/Object;

    aget-object v4, v4, v3

    invoke-virtual {p1, v4}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_5

    return v3

    .line 112
    :cond_5
    add-int/lit8 v3, v3, -0x1

    goto :goto_1

    .line 120
    .end local v3    # "i":I
    :cond_6
    xor-int/lit8 v3, v2, -0x1

    return v3
.end method

.method private a()La/b/c/f/j;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "La/b/c/f/j<",
            "TE;TE;>;"
        }
    .end annotation

    .line 666
    .local p0, "this":La/b/c/f/d;, "Landroid/support/v4/util/ArraySet<TE;>;"
    iget-object v0, p0, La/b/c/f/d;->j:La/b/c/f/j;

    if-nez v0, :cond_0

    .line 667
    new-instance v0, La/b/c/f/c;

    invoke-direct {v0, p0}, La/b/c/f/c;-><init>(La/b/c/f/d;)V

    iput-object v0, p0, La/b/c/f/d;->j:La/b/c/f/j;

    .line 714
    :cond_0
    iget-object v0, p0, La/b/c/f/d;->j:La/b/c/f/j;

    return-object v0
.end method

.method private static a([I[Ljava/lang/Object;I)V
    .locals 7
    .param p0, "hashes"    # [I
    .param p1, "array"    # [Ljava/lang/Object;
    .param p2, "size"    # I

    .line 203
    array-length v0, p0

    const/4 v1, 0x0

    const/4 v2, 0x2

    const/4 v3, 0x0

    const/16 v4, 0xa

    const/4 v5, 0x1

    const/16 v6, 0x8

    if-ne v0, v6, :cond_2

    .line 204
    const-class v0, La/b/c/f/d;

    monitor-enter v0

    .line 205
    :try_start_0
    sget v6, La/b/c/f/d;->f:I

    if-ge v6, v4, :cond_1

    .line 206
    sget-object v4, La/b/c/f/d;->e:[Ljava/lang/Object;

    aput-object v4, p1, v3

    .line 207
    aput-object p0, p1, v5

    .line 208
    add-int/lit8 v3, p2, -0x1

    .local v3, "i":I
    :goto_0
    if-lt v3, v2, :cond_0

    .line 209
    aput-object v1, p1, v3

    .line 208
    add-int/lit8 v3, v3, -0x1

    goto :goto_0

    .line 211
    .end local v3    # "i":I
    :cond_0
    sput-object p1, La/b/c/f/d;->e:[Ljava/lang/Object;

    .line 212
    sget v1, La/b/c/f/d;->f:I

    add-int/2addr v1, v5

    sput v1, La/b/c/f/d;->f:I

    .line 218
    :cond_1
    monitor-exit v0

    goto :goto_2

    :catchall_0
    move-exception v1

    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1

    .line 219
    :cond_2
    array-length v0, p0

    const/4 v6, 0x4

    if-ne v0, v6, :cond_5

    .line 220
    const-class v0, La/b/c/f/d;

    monitor-enter v0

    .line 221
    :try_start_1
    sget v6, La/b/c/f/d;->d:I

    if-ge v6, v4, :cond_4

    .line 222
    sget-object v4, La/b/c/f/d;->c:[Ljava/lang/Object;

    aput-object v4, p1, v3

    .line 223
    aput-object p0, p1, v5

    .line 224
    add-int/lit8 v3, p2, -0x1

    .restart local v3    # "i":I
    :goto_1
    if-lt v3, v2, :cond_3

    .line 225
    aput-object v1, p1, v3

    .line 224
    add-int/lit8 v3, v3, -0x1

    goto :goto_1

    .line 227
    .end local v3    # "i":I
    :cond_3
    sput-object p1, La/b/c/f/d;->c:[Ljava/lang/Object;

    .line 228
    sget v1, La/b/c/f/d;->d:I

    add-int/2addr v1, v5

    sput v1, La/b/c/f/d;->d:I

    .line 234
    :cond_4
    monitor-exit v0

    goto :goto_2

    :catchall_1
    move-exception v1

    monitor-exit v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    throw v1

    .line 236
    :cond_5
    :goto_2
    return-void
.end method

.method private b()I
    .locals 5

    .line 124
    .local p0, "this":La/b/c/f/d;, "Landroid/support/v4/util/ArraySet<TE;>;"
    iget v0, p0, La/b/c/f/d;->i:I

    .line 127
    .local v0, "N":I
    if-nez v0, :cond_0

    .line 128
    const/4 v1, -0x1

    return v1

    .line 131
    :cond_0
    iget-object v1, p0, La/b/c/f/d;->g:[I

    const/4 v2, 0x0

    invoke-static {v1, v0, v2}, La/b/c/f/e;->a([III)I

    move-result v1

    .line 134
    .local v1, "index":I
    if-gez v1, :cond_1

    .line 135
    return v1

    .line 139
    :cond_1
    iget-object v2, p0, La/b/c/f/d;->h:[Ljava/lang/Object;

    aget-object v2, v2, v1

    if-nez v2, :cond_2

    .line 140
    return v1

    .line 145
    :cond_2
    add-int/lit8 v2, v1, 0x1

    .local v2, "end":I
    :goto_0
    if-ge v2, v0, :cond_4

    iget-object v3, p0, La/b/c/f/d;->g:[I

    aget v3, v3, v2

    if-nez v3, :cond_4

    .line 146
    iget-object v3, p0, La/b/c/f/d;->h:[Ljava/lang/Object;

    aget-object v3, v3, v2

    if-nez v3, :cond_3

    return v2

    .line 145
    :cond_3
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 150
    :cond_4
    add-int/lit8 v3, v1, -0x1

    .local v3, "i":I
    :goto_1
    if-ltz v3, :cond_6

    iget-object v4, p0, La/b/c/f/d;->g:[I

    aget v4, v4, v3

    if-nez v4, :cond_6

    .line 151
    iget-object v4, p0, La/b/c/f/d;->h:[Ljava/lang/Object;

    aget-object v4, v4, v3

    if-nez v4, :cond_5

    return v3

    .line 150
    :cond_5
    add-int/lit8 v3, v3, -0x1

    goto :goto_1

    .line 158
    .end local v3    # "i":I
    :cond_6
    xor-int/lit8 v3, v2, -0x1

    return v3
.end method

.method private d(I)V
    .locals 6
    .param p1, "size"    # I

    .line 163
    .local p0, "this":La/b/c/f/d;, "Landroid/support/v4/util/ArraySet<TE;>;"
    const/4 v0, 0x0

    const/4 v1, 0x0

    const/4 v2, 0x1

    const/16 v3, 0x8

    if-ne p1, v3, :cond_1

    .line 164
    const-class v3, La/b/c/f/d;

    monitor-enter v3

    .line 165
    :try_start_0
    sget-object v4, La/b/c/f/d;->e:[Ljava/lang/Object;

    if-eqz v4, :cond_0

    .line 166
    sget-object v4, La/b/c/f/d;->e:[Ljava/lang/Object;

    .line 167
    .local v4, "array":[Ljava/lang/Object;
    iput-object v4, p0, La/b/c/f/d;->h:[Ljava/lang/Object;

    .line 168
    aget-object v5, v4, v1

    check-cast v5, [Ljava/lang/Object;

    sput-object v5, La/b/c/f/d;->e:[Ljava/lang/Object;

    .line 169
    aget-object v5, v4, v2

    check-cast v5, [I

    iput-object v5, p0, La/b/c/f/d;->g:[I

    .line 170
    aput-object v0, v4, v2

    aput-object v0, v4, v1

    .line 171
    sget v0, La/b/c/f/d;->f:I

    sub-int/2addr v0, v2

    sput v0, La/b/c/f/d;->f:I

    .line 176
    monitor-exit v3

    return-void

    .line 178
    .end local v4    # "array":[Ljava/lang/Object;
    :cond_0
    monitor-exit v3

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    .line 179
    :cond_1
    const/4 v3, 0x4

    if-ne p1, v3, :cond_3

    .line 180
    const-class v3, La/b/c/f/d;

    monitor-enter v3

    .line 181
    :try_start_1
    sget-object v4, La/b/c/f/d;->c:[Ljava/lang/Object;

    if-eqz v4, :cond_2

    .line 182
    sget-object v4, La/b/c/f/d;->c:[Ljava/lang/Object;

    .line 183
    .restart local v4    # "array":[Ljava/lang/Object;
    iput-object v4, p0, La/b/c/f/d;->h:[Ljava/lang/Object;

    .line 184
    aget-object v5, v4, v1

    check-cast v5, [Ljava/lang/Object;

    sput-object v5, La/b/c/f/d;->c:[Ljava/lang/Object;

    .line 185
    aget-object v5, v4, v2

    check-cast v5, [I

    iput-object v5, p0, La/b/c/f/d;->g:[I

    .line 186
    aput-object v0, v4, v2

    aput-object v0, v4, v1

    .line 187
    sget v0, La/b/c/f/d;->d:I

    sub-int/2addr v0, v2

    sput v0, La/b/c/f/d;->d:I

    .line 192
    monitor-exit v3

    return-void

    .line 194
    .end local v4    # "array":[Ljava/lang/Object;
    :cond_2
    monitor-exit v3

    goto :goto_0

    :catchall_1
    move-exception v0

    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    throw v0

    .line 197
    :cond_3
    :goto_0
    new-array v0, p1, [I

    iput-object v0, p0, La/b/c/f/d;->g:[I

    .line 198
    new-array v0, p1, [Ljava/lang/Object;

    iput-object v0, p0, La/b/c/f/d;->h:[Ljava/lang/Object;

    .line 199
    return-void
.end method


# virtual methods
.method public a(I)V
    .locals 5
    .param p1, "minimumCapacity"    # I

    .line 298
    .local p0, "this":La/b/c/f/d;, "Landroid/support/v4/util/ArraySet<TE;>;"
    iget-object v0, p0, La/b/c/f/d;->g:[I

    array-length v0, v0

    if-ge v0, p1, :cond_1

    .line 299
    iget-object v0, p0, La/b/c/f/d;->g:[I

    .line 300
    .local v0, "ohashes":[I
    iget-object v1, p0, La/b/c/f/d;->h:[Ljava/lang/Object;

    .line 301
    .local v1, "oarray":[Ljava/lang/Object;
    invoke-direct {p0, p1}, La/b/c/f/d;->d(I)V

    .line 302
    iget v2, p0, La/b/c/f/d;->i:I

    if-lez v2, :cond_0

    .line 303
    iget-object v3, p0, La/b/c/f/d;->g:[I

    const/4 v4, 0x0

    invoke-static {v0, v4, v3, v4, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 304
    iget-object v2, p0, La/b/c/f/d;->h:[Ljava/lang/Object;

    iget v3, p0, La/b/c/f/d;->i:I

    invoke-static {v1, v4, v2, v4, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 306
    :cond_0
    iget v2, p0, La/b/c/f/d;->i:I

    invoke-static {v0, v1, v2}, La/b/c/f/d;->a([I[Ljava/lang/Object;I)V

    .line 308
    .end local v0    # "ohashes":[I
    .end local v1    # "oarray":[Ljava/lang/Object;
    :cond_1
    return-void
.end method

.method public add(Ljava/lang/Object;)Z
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TE;)Z"
        }
    .end annotation

    .line 362
    .local p0, "this":La/b/c/f/d;, "Landroid/support/v4/util/ArraySet<TE;>;"
    .local p1, "value":Ljava/lang/Object;, "TE;"
    if-nez p1, :cond_0

    .line 363
    const/4 v0, 0x0

    .line 364
    .local v0, "hash":I
    invoke-direct {p0}, La/b/c/f/d;->b()I

    move-result v1

    .local v1, "index":I
    goto :goto_0

    .line 366
    .end local v0    # "hash":I
    .end local v1    # "index":I
    :cond_0
    invoke-virtual {p1}, Ljava/lang/Object;->hashCode()I

    move-result v0

    .line 367
    .restart local v0    # "hash":I
    invoke-direct {p0, p1, v0}, La/b/c/f/d;->a(Ljava/lang/Object;I)I

    move-result v1

    .line 369
    .restart local v1    # "index":I
    :goto_0
    const/4 v2, 0x0

    if-ltz v1, :cond_1

    .line 370
    return v2

    .line 373
    :cond_1
    xor-int/lit8 v1, v1, -0x1

    .line 374
    iget v3, p0, La/b/c/f/d;->i:I

    iget-object v4, p0, La/b/c/f/d;->g:[I

    array-length v4, v4

    if-lt v3, v4, :cond_5

    .line 375
    const/4 v4, 0x4

    const/16 v5, 0x8

    if-lt v3, v5, :cond_2

    shr-int/lit8 v4, v3, 0x1

    add-int/2addr v4, v3

    goto :goto_1

    :cond_2
    if-lt v3, v4, :cond_3

    const/16 v4, 0x8

    :cond_3
    :goto_1
    move v3, v4

    .line 380
    .local v3, "n":I
    iget-object v4, p0, La/b/c/f/d;->g:[I

    .line 381
    .local v4, "ohashes":[I
    iget-object v5, p0, La/b/c/f/d;->h:[Ljava/lang/Object;

    .line 382
    .local v5, "oarray":[Ljava/lang/Object;
    invoke-direct {p0, v3}, La/b/c/f/d;->d(I)V

    .line 384
    iget-object v6, p0, La/b/c/f/d;->g:[I

    array-length v7, v6

    if-lez v7, :cond_4

    .line 386
    array-length v7, v4

    invoke-static {v4, v2, v6, v2, v7}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 387
    iget-object v6, p0, La/b/c/f/d;->h:[Ljava/lang/Object;

    array-length v7, v5

    invoke-static {v5, v2, v6, v2, v7}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 390
    :cond_4
    iget v2, p0, La/b/c/f/d;->i:I

    invoke-static {v4, v5, v2}, La/b/c/f/d;->a([I[Ljava/lang/Object;I)V

    .line 393
    .end local v3    # "n":I
    .end local v4    # "ohashes":[I
    .end local v5    # "oarray":[Ljava/lang/Object;
    :cond_5
    iget v2, p0, La/b/c/f/d;->i:I

    if-ge v1, v2, :cond_6

    .line 398
    iget-object v3, p0, La/b/c/f/d;->g:[I

    add-int/lit8 v4, v1, 0x1

    sub-int/2addr v2, v1

    invoke-static {v3, v1, v3, v4, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 399
    iget-object v2, p0, La/b/c/f/d;->h:[Ljava/lang/Object;

    add-int/lit8 v3, v1, 0x1

    iget v4, p0, La/b/c/f/d;->i:I

    sub-int/2addr v4, v1

    invoke-static {v2, v1, v2, v3, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 402
    :cond_6
    iget-object v2, p0, La/b/c/f/d;->g:[I

    aput v0, v2, v1

    .line 403
    iget-object v2, p0, La/b/c/f/d;->h:[Ljava/lang/Object;

    aput-object p1, v2, v1

    .line 404
    iget v2, p0, La/b/c/f/d;->i:I

    const/4 v3, 0x1

    add-int/2addr v2, v3

    iput v2, p0, La/b/c/f/d;->i:I

    .line 405
    return v3
.end method

.method public addAll(Ljava/util/Collection;)Z
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection<",
            "+TE;>;)Z"
        }
    .end annotation

    .line 752
    .local p0, "this":La/b/c/f/d;, "Landroid/support/v4/util/ArraySet<TE;>;"
    .local p1, "collection":Ljava/util/Collection;, "Ljava/util/Collection<+TE;>;"
    iget v0, p0, La/b/c/f/d;->i:I

    invoke-interface {p1}, Ljava/util/Collection;->size()I

    move-result v1

    add-int/2addr v0, v1

    invoke-virtual {p0, v0}, La/b/c/f/d;->a(I)V

    .line 753
    const/4 v0, 0x0

    .line 754
    .local v0, "added":Z
    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    .line 755
    .local v2, "value":Ljava/lang/Object;, "TE;"
    invoke-virtual {p0, v2}, La/b/c/f/d;->add(Ljava/lang/Object;)Z

    move-result v3

    or-int/2addr v0, v3

    .line 756
    .end local v2    # "value":Ljava/lang/Object;, "TE;"
    goto :goto_0

    .line 757
    :cond_0
    return v0
.end method

.method public b(I)Ljava/lang/Object;
    .locals 7
    .param p1, "index"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)TE;"
        }
    .end annotation

    .line 479
    .local p0, "this":La/b/c/f/d;, "Landroid/support/v4/util/ArraySet<TE;>;"
    iget-object v0, p0, La/b/c/f/d;->h:[Ljava/lang/Object;

    aget-object v1, v0, p1

    .line 480
    .local v1, "old":Ljava/lang/Object;
    iget v2, p0, La/b/c/f/d;->i:I

    const/4 v3, 0x0

    const/4 v4, 0x1

    if-gt v2, v4, :cond_0

    .line 483
    iget-object v4, p0, La/b/c/f/d;->g:[I

    invoke-static {v4, v0, v2}, La/b/c/f/d;->a([I[Ljava/lang/Object;I)V

    .line 484
    sget-object v0, La/b/c/f/d;->a:[I

    iput-object v0, p0, La/b/c/f/d;->g:[I

    .line 485
    sget-object v0, La/b/c/f/d;->b:[Ljava/lang/Object;

    iput-object v0, p0, La/b/c/f/d;->h:[Ljava/lang/Object;

    .line 486
    iput v3, p0, La/b/c/f/d;->i:I

    goto :goto_0

    .line 488
    :cond_0
    iget-object v0, p0, La/b/c/f/d;->g:[I

    array-length v5, v0

    const/16 v6, 0x8

    if-le v5, v6, :cond_4

    array-length v0, v0

    div-int/lit8 v0, v0, 0x3

    if-ge v2, v0, :cond_4

    .line 492
    if-le v2, v6, :cond_1

    shr-int/lit8 v0, v2, 0x1

    add-int v6, v2, v0

    :cond_1
    move v0, v6

    .line 496
    .local v0, "n":I
    iget-object v2, p0, La/b/c/f/d;->g:[I

    .line 497
    .local v2, "ohashes":[I
    iget-object v5, p0, La/b/c/f/d;->h:[Ljava/lang/Object;

    .line 498
    .local v5, "oarray":[Ljava/lang/Object;
    invoke-direct {p0, v0}, La/b/c/f/d;->d(I)V

    .line 500
    iget v6, p0, La/b/c/f/d;->i:I

    sub-int/2addr v6, v4

    iput v6, p0, La/b/c/f/d;->i:I

    .line 501
    if-lez p1, :cond_2

    .line 503
    iget-object v4, p0, La/b/c/f/d;->g:[I

    invoke-static {v2, v3, v4, v3, p1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 504
    iget-object v4, p0, La/b/c/f/d;->h:[Ljava/lang/Object;

    invoke-static {v5, v3, v4, v3, p1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 506
    :cond_2
    iget v3, p0, La/b/c/f/d;->i:I

    if-ge p1, v3, :cond_3

    .line 511
    add-int/lit8 v4, p1, 0x1

    iget-object v6, p0, La/b/c/f/d;->g:[I

    sub-int/2addr v3, p1

    invoke-static {v2, v4, v6, p1, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 512
    add-int/lit8 v3, p1, 0x1

    iget-object v4, p0, La/b/c/f/d;->h:[Ljava/lang/Object;

    iget v6, p0, La/b/c/f/d;->i:I

    sub-int/2addr v6, p1

    invoke-static {v5, v3, v4, p1, v6}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 514
    .end local v0    # "n":I
    .end local v2    # "ohashes":[I
    .end local v5    # "oarray":[Ljava/lang/Object;
    :cond_3
    goto :goto_0

    .line 515
    :cond_4
    iget v0, p0, La/b/c/f/d;->i:I

    sub-int/2addr v0, v4

    iput v0, p0, La/b/c/f/d;->i:I

    .line 516
    iget v0, p0, La/b/c/f/d;->i:I

    if-ge p1, v0, :cond_5

    .line 520
    iget-object v2, p0, La/b/c/f/d;->g:[I

    add-int/lit8 v3, p1, 0x1

    sub-int/2addr v0, p1

    invoke-static {v2, v3, v2, p1, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 521
    iget-object v0, p0, La/b/c/f/d;->h:[Ljava/lang/Object;

    add-int/lit8 v2, p1, 0x1

    iget v3, p0, La/b/c/f/d;->i:I

    sub-int/2addr v3, p1

    invoke-static {v0, v2, v0, p1, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 523
    :cond_5
    iget-object v0, p0, La/b/c/f/d;->h:[Ljava/lang/Object;

    iget v2, p0, La/b/c/f/d;->i:I

    const/4 v3, 0x0

    aput-object v3, v0, v2

    .line 526
    :goto_0
    return-object v1
.end method

.method public c(I)Ljava/lang/Object;
    .locals 1
    .param p1, "index"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)TE;"
        }
    .end annotation

    .line 338
    .local p0, "this":La/b/c/f/d;, "Landroid/support/v4/util/ArraySet<TE;>;"
    iget-object v0, p0, La/b/c/f/d;->h:[Ljava/lang/Object;

    aget-object v0, v0, p1

    return-object v0
.end method

.method public clear()V
    .locals 3

    .line 285
    .local p0, "this":La/b/c/f/d;, "Landroid/support/v4/util/ArraySet<TE;>;"
    iget v0, p0, La/b/c/f/d;->i:I

    if-eqz v0, :cond_0

    .line 286
    iget-object v1, p0, La/b/c/f/d;->g:[I

    iget-object v2, p0, La/b/c/f/d;->h:[Ljava/lang/Object;

    invoke-static {v1, v2, v0}, La/b/c/f/d;->a([I[Ljava/lang/Object;I)V

    .line 287
    sget-object v0, La/b/c/f/d;->a:[I

    iput-object v0, p0, La/b/c/f/d;->g:[I

    .line 288
    sget-object v0, La/b/c/f/d;->b:[Ljava/lang/Object;

    iput-object v0, p0, La/b/c/f/d;->h:[Ljava/lang/Object;

    .line 289
    const/4 v0, 0x0

    iput v0, p0, La/b/c/f/d;->i:I

    .line 291
    :cond_0
    return-void
.end method

.method public contains(Ljava/lang/Object;)Z
    .locals 1
    .param p1, "key"    # Ljava/lang/Object;

    .line 318
    .local p0, "this":La/b/c/f/d;, "Landroid/support/v4/util/ArraySet<TE;>;"
    invoke-virtual {p0, p1}, La/b/c/f/d;->indexOf(Ljava/lang/Object;)I

    move-result v0

    if-ltz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public containsAll(Ljava/util/Collection;)Z
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection<",
            "*>;)Z"
        }
    .end annotation

    .line 737
    .local p0, "this":La/b/c/f/d;, "Landroid/support/v4/util/ArraySet<TE;>;"
    .local p1, "collection":Ljava/util/Collection;, "Ljava/util/Collection<*>;"
    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 738
    .local v0, "it":Ljava/util/Iterator;, "Ljava/util/Iterator<*>;"
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 739
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {p0, v1}, La/b/c/f/d;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 740
    const/4 v1, 0x0

    return v1

    .line 743
    :cond_1
    const/4 v1, 0x1

    return v1
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 6
    .param p1, "object"    # Ljava/lang/Object;

    .line 591
    .local p0, "this":La/b/c/f/d;, "Landroid/support/v4/util/ArraySet<TE;>;"
    const/4 v0, 0x1

    if-ne p0, p1, :cond_0

    .line 592
    return v0

    .line 594
    :cond_0
    instance-of v1, p1, Ljava/util/Set;

    const/4 v2, 0x0

    if-eqz v1, :cond_4

    .line 595
    move-object v1, p1

    check-cast v1, Ljava/util/Set;

    .line 596
    .local v1, "set":Ljava/util/Set;, "Ljava/util/Set<*>;"
    invoke-virtual {p0}, La/b/c/f/d;->size()I

    move-result v3

    invoke-interface {v1}, Ljava/util/Set;->size()I

    move-result v4

    if-eq v3, v4, :cond_1

    .line 597
    return v2

    .line 601
    :cond_1
    move v3, v2

    .local v3, "i":I
    :goto_0
    :try_start_0
    iget v4, p0, La/b/c/f/d;->i:I

    if-ge v3, v4, :cond_3

    .line 602
    invoke-virtual {p0, v3}, La/b/c/f/d;->c(I)Ljava/lang/Object;

    move-result-object v4

    .line 603
    .local v4, "mine":Ljava/lang/Object;, "TE;"
    invoke-interface {v1, v4}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v5
    :try_end_0
    .catch Ljava/lang/NullPointerException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/ClassCastException; {:try_start_0 .. :try_end_0} :catch_0

    if-nez v5, :cond_2

    .line 604
    return v2

    .line 601
    .end local v4    # "mine":Ljava/lang/Object;, "TE;"
    :cond_2
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 611
    .end local v3    # "i":I
    :cond_3
    nop

    .line 612
    return v0

    .line 609
    :catch_0
    move-exception v0

    .line 610
    .local v0, "ignored":Ljava/lang/ClassCastException;
    return v2

    .line 607
    .end local v0    # "ignored":Ljava/lang/ClassCastException;
    :catch_1
    move-exception v0

    .line 608
    .local v0, "ignored":Ljava/lang/NullPointerException;
    return v2

    .line 614
    .end local v0    # "ignored":Ljava/lang/NullPointerException;
    .end local v1    # "set":Ljava/util/Set;, "Ljava/util/Set<*>;"
    :cond_4
    return v2
.end method

.method public hashCode()I
    .locals 5

    .line 622
    .local p0, "this":La/b/c/f/d;, "Landroid/support/v4/util/ArraySet<TE;>;"
    iget-object v0, p0, La/b/c/f/d;->g:[I

    .line 623
    .local v0, "hashes":[I
    const/4 v1, 0x0

    .line 624
    .local v1, "result":I
    const/4 v2, 0x0

    .local v2, "i":I
    iget v3, p0, La/b/c/f/d;->i:I

    .local v3, "s":I
    :goto_0
    if-ge v2, v3, :cond_0

    .line 625
    aget v4, v0, v2

    add-int/2addr v1, v4

    .line 624
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 627
    .end local v2    # "i":I
    .end local v3    # "s":I
    :cond_0
    return v1
.end method

.method public indexOf(Ljava/lang/Object;)I
    .locals 1
    .param p1, "key"    # Ljava/lang/Object;

    .line 328
    .local p0, "this":La/b/c/f/d;, "Landroid/support/v4/util/ArraySet<TE;>;"
    if-nez p1, :cond_0

    invoke-direct {p0}, La/b/c/f/d;->b()I

    move-result v0

    goto :goto_0

    :cond_0
    invoke-virtual {p1}, Ljava/lang/Object;->hashCode()I

    move-result v0

    invoke-direct {p0, p1, v0}, La/b/c/f/d;->a(Ljava/lang/Object;I)I

    move-result v0

    :goto_0
    return v0
.end method

.method public isEmpty()Z
    .locals 1

    .line 346
    .local p0, "this":La/b/c/f/d;, "Landroid/support/v4/util/ArraySet<TE;>;"
    iget v0, p0, La/b/c/f/d;->i:I

    if-gtz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public iterator()Ljava/util/Iterator;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Iterator<",
            "TE;>;"
        }
    .end annotation

    .line 726
    .local p0, "this":La/b/c/f/d;, "Landroid/support/v4/util/ArraySet<TE;>;"
    invoke-direct {p0}, La/b/c/f/d;->a()La/b/c/f/j;

    move-result-object v0

    invoke-virtual {v0}, La/b/c/f/j;->e()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    return-object v0
.end method

.method public remove(Ljava/lang/Object;)Z
    .locals 2
    .param p1, "object"    # Ljava/lang/Object;

    .line 465
    .local p0, "this":La/b/c/f/d;, "Landroid/support/v4/util/ArraySet<TE;>;"
    invoke-virtual {p0, p1}, La/b/c/f/d;->indexOf(Ljava/lang/Object;)I

    move-result v0

    .line 466
    .local v0, "index":I
    if-ltz v0, :cond_0

    .line 467
    invoke-virtual {p0, v0}, La/b/c/f/d;->b(I)Ljava/lang/Object;

    .line 468
    const/4 v1, 0x1

    return v1

    .line 470
    :cond_0
    const/4 v1, 0x0

    return v1
.end method

.method public removeAll(Ljava/util/Collection;)Z
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection<",
            "*>;)Z"
        }
    .end annotation

    .line 767
    .local p0, "this":La/b/c/f/d;, "Landroid/support/v4/util/ArraySet<TE;>;"
    .local p1, "collection":Ljava/util/Collection;, "Ljava/util/Collection<*>;"
    const/4 v0, 0x0

    .line 768
    .local v0, "removed":Z
    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    .line 769
    .local v2, "value":Ljava/lang/Object;
    invoke-virtual {p0, v2}, La/b/c/f/d;->remove(Ljava/lang/Object;)Z

    move-result v3

    or-int/2addr v0, v3

    .line 770
    .end local v2    # "value":Ljava/lang/Object;
    goto :goto_0

    .line 771
    :cond_0
    return v0
.end method

.method public retainAll(Ljava/util/Collection;)Z
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection<",
            "*>;)Z"
        }
    .end annotation

    .line 782
    .local p0, "this":La/b/c/f/d;, "Landroid/support/v4/util/ArraySet<TE;>;"
    .local p1, "collection":Ljava/util/Collection;, "Ljava/util/Collection<*>;"
    const/4 v0, 0x0

    .line 783
    .local v0, "removed":Z
    iget v1, p0, La/b/c/f/d;->i:I

    add-int/lit8 v1, v1, -0x1

    .local v1, "i":I
    :goto_0
    if-ltz v1, :cond_1

    .line 784
    iget-object v2, p0, La/b/c/f/d;->h:[Ljava/lang/Object;

    aget-object v2, v2, v1

    invoke-interface {p1, v2}, Ljava/util/Collection;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 785
    invoke-virtual {p0, v1}, La/b/c/f/d;->b(I)Ljava/lang/Object;

    .line 786
    const/4 v0, 0x1

    .line 783
    :cond_0
    add-int/lit8 v1, v1, -0x1

    goto :goto_0

    .line 789
    .end local v1    # "i":I
    :cond_1
    return v0
.end method

.method public size()I
    .locals 1

    .line 554
    .local p0, "this":La/b/c/f/d;, "Landroid/support/v4/util/ArraySet<TE;>;"
    iget v0, p0, La/b/c/f/d;->i:I

    return v0
.end method

.method public toArray()[Ljava/lang/Object;
    .locals 4

    .line 560
    .local p0, "this":La/b/c/f/d;, "Landroid/support/v4/util/ArraySet<TE;>;"
    iget v0, p0, La/b/c/f/d;->i:I

    new-array v1, v0, [Ljava/lang/Object;

    .line 561
    .local v1, "result":[Ljava/lang/Object;
    iget-object v2, p0, La/b/c/f/d;->h:[Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-static {v2, v3, v1, v3, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 562
    return-object v1
.end method

.method public toArray([Ljava/lang/Object;)[Ljava/lang/Object;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">([TT;)[TT;"
        }
    .end annotation

    .line 568
    .local p0, "this":La/b/c/f/d;, "Landroid/support/v4/util/ArraySet<TE;>;"
    .local p1, "array":[Ljava/lang/Object;, "[TT;"
    array-length v0, p1

    iget v1, p0, La/b/c/f/d;->i:I

    if-ge v0, v1, :cond_0

    .line 569
    nop

    .line 570
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    move-result-object v0

    iget v1, p0, La/b/c/f/d;->i:I

    invoke-static {v0, v1}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Ljava/lang/Object;

    .line 571
    .local v0, "newArray":[Ljava/lang/Object;, "[TT;"
    move-object p1, v0

    .line 573
    .end local v0    # "newArray":[Ljava/lang/Object;, "[TT;"
    :cond_0
    iget-object v0, p0, La/b/c/f/d;->h:[Ljava/lang/Object;

    iget v1, p0, La/b/c/f/d;->i:I

    const/4 v2, 0x0

    invoke-static {v0, v2, p1, v2, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 574
    array-length v0, p1

    iget v1, p0, La/b/c/f/d;->i:I

    if-le v0, v1, :cond_1

    .line 575
    const/4 v0, 0x0

    aput-object v0, p1, v1

    .line 577
    :cond_1
    return-object p1
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .line 639
    .local p0, "this":La/b/c/f/d;, "Landroid/support/v4/util/ArraySet<TE;>;"
    invoke-virtual {p0}, La/b/c/f/d;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 640
    const-string v0, "{}"

    return-object v0

    .line 643
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    iget v1, p0, La/b/c/f/d;->i:I

    mul-int/lit8 v1, v1, 0xe

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 644
    .local v0, "buffer":Ljava/lang/StringBuilder;
    const/16 v1, 0x7b

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 645
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget v2, p0, La/b/c/f/d;->i:I

    if-ge v1, v2, :cond_3

    .line 646
    if-lez v1, :cond_1

    .line 647
    const-string v2, ", "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 649
    :cond_1
    invoke-virtual {p0, v1}, La/b/c/f/d;->c(I)Ljava/lang/Object;

    move-result-object v2

    .line 650
    .local v2, "value":Ljava/lang/Object;
    if-eq v2, p0, :cond_2

    .line 651
    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 653
    :cond_2
    const-string v3, "(this Set)"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 645
    .end local v2    # "value":Ljava/lang/Object;
    :goto_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 656
    .end local v1    # "i":I
    :cond_3
    const/16 v1, 0x7d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 657
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
