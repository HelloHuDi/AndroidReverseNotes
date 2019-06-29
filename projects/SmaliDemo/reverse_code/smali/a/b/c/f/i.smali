.class public La/b/c/f/i;
.super Ljava/lang/Object;
.source ""


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<K:",
        "Ljava/lang/Object;",
        "V:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private final a:Ljava/util/LinkedHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedHashMap<",
            "TK;TV;>;"
        }
    .end annotation
.end field

.field private b:I

.field private c:I

.field private d:I

.field private e:I

.field private f:I

.field private g:I

.field private h:I


# direct methods
.method public constructor <init>(I)V
    .locals 4
    .param p1, "maxSize"    # I

    .line 51
    .local p0, "this":La/b/c/f/i;, "Landroid/support/v4/util/LruCache<TK;TV;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 52
    if-lez p1, :cond_0

    .line 55
    iput p1, p0, La/b/c/f/i;->c:I

    .line 56
    new-instance v0, Ljava/util/LinkedHashMap;

    const/4 v1, 0x0

    const/high16 v2, 0x3f400000    # 0.75f

    const/4 v3, 0x1

    invoke-direct {v0, v1, v2, v3}, Ljava/util/LinkedHashMap;-><init>(IFZ)V

    iput-object v0, p0, La/b/c/f/i;->a:Ljava/util/LinkedHashMap;

    .line 57
    return-void

    .line 53
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "maxSize <= 0"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private c(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;TV;)I"
        }
    .end annotation

    .line 259
    .local p0, "this":La/b/c/f/i;, "Landroid/support/v4/util/LruCache<TK;TV;>;"
    .local p1, "key":Ljava/lang/Object;, "TK;"
    .local p2, "value":Ljava/lang/Object;, "TV;"
    invoke-virtual {p0, p1, p2}, La/b/c/f/i;->b(Ljava/lang/Object;Ljava/lang/Object;)I

    move-result v0

    .line 260
    .local v0, "result":I
    if-ltz v0, :cond_0

    .line 263
    return v0

    .line 261
    :cond_0
    new-instance v1, Ljava/lang/IllegalStateException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Negative size: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v3, "="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1
.end method


# virtual methods
.method protected a(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;)TV;"
        }
    .end annotation

    .line 255
    .local p0, "this":La/b/c/f/i;, "Landroid/support/v4/util/LruCache<TK;TV;>;"
    .local p1, "key":Ljava/lang/Object;, "TK;"
    const/4 v0, 0x0

    return-object v0
.end method

.method public final a(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;TV;)TV;"
        }
    .end annotation

    .line 138
    .local p0, "this":La/b/c/f/i;, "Landroid/support/v4/util/LruCache<TK;TV;>;"
    .local p1, "key":Ljava/lang/Object;, "TK;"
    .local p2, "value":Ljava/lang/Object;, "TV;"
    if-eqz p1, :cond_2

    if-eqz p2, :cond_2

    .line 143
    monitor-enter p0

    .line 144
    const/4 v0, 0x0

    :try_start_0
    iget v1, p0, La/b/c/f/i;->d:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, La/b/c/f/i;->d:I

    .line 145
    iget v1, p0, La/b/c/f/i;->b:I

    invoke-direct {p0, p1, p2}, La/b/c/f/i;->c(Ljava/lang/Object;Ljava/lang/Object;)I

    move-result v2

    add-int/2addr v1, v2

    iput v1, p0, La/b/c/f/i;->b:I

    .line 146
    iget-object v1, p0, La/b/c/f/i;->a:Ljava/util/LinkedHashMap;

    invoke-virtual {v1, p1, p2}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 147
    .local v0, "previous":Ljava/lang/Object;, "TV;"
    if-eqz v0, :cond_0

    .line 148
    :try_start_1
    iget v1, p0, La/b/c/f/i;->b:I

    invoke-direct {p0, p1, v0}, La/b/c/f/i;->c(Ljava/lang/Object;Ljava/lang/Object;)I

    move-result v2

    sub-int/2addr v1, v2

    iput v1, p0, La/b/c/f/i;->b:I

    .line 150
    :cond_0
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 152
    if-eqz v0, :cond_1

    .line 153
    const/4 v1, 0x0

    invoke-virtual {p0, v1, p1, v0, p2}, La/b/c/f/i;->a(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 156
    :cond_1
    iget v1, p0, La/b/c/f/i;->c:I

    invoke-virtual {p0, v1}, La/b/c/f/i;->a(I)V

    .line 157
    return-object v0

    .line 150
    .end local v0    # "previous":Ljava/lang/Object;, "TV;"
    :catchall_0
    move-exception v1

    .restart local v0    # "previous":Ljava/lang/Object;, "TV;"
    :goto_0
    :try_start_2
    monitor-exit p0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    throw v1

    :catchall_1
    move-exception v1

    goto :goto_0

    .line 139
    .end local v0    # "previous":Ljava/lang/Object;, "TV;"
    :cond_2
    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "key == null || value == null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    goto :goto_2

    :goto_1
    throw v0

    :goto_2
    goto :goto_1
.end method

.method public a(I)V
    .locals 6
    .param p1, "maxSize"    # I

    .local p0, "this":La/b/c/f/i;, "Landroid/support/v4/util/LruCache<TK;TV;>;"
    const/4 v0, 0x0

    move-object v1, v0

    move-object v2, v1

    .line 171
    :goto_0
    monitor-enter p0

    .line 172
    :try_start_0
    iget v3, p0, La/b/c/f/i;->b:I

    if-ltz v3, :cond_3

    iget-object v3, p0, La/b/c/f/i;->a:Ljava/util/LinkedHashMap;

    invoke-virtual {v3}, Ljava/util/LinkedHashMap;->isEmpty()Z

    move-result v3

    if-eqz v3, :cond_0

    iget v3, p0, La/b/c/f/i;->b:I

    if-nez v3, :cond_3

    .line 177
    :cond_0
    iget v3, p0, La/b/c/f/i;->b:I

    if-le v3, p1, :cond_2

    iget-object v3, p0, La/b/c/f/i;->a:Ljava/util/LinkedHashMap;

    invoke-virtual {v3}, Ljava/util/LinkedHashMap;->isEmpty()Z

    move-result v3

    if-eqz v3, :cond_1

    goto :goto_1

    .line 181
    :cond_1
    iget-object v3, p0, La/b/c/f/i;->a:Ljava/util/LinkedHashMap;

    invoke-virtual {v3}, Ljava/util/LinkedHashMap;->entrySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/Map$Entry;

    .line 182
    .local v3, "toEvict":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<TK;TV;>;"
    invoke-interface {v3}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 183
    .local v1, "key":Ljava/lang/Object;, "TK;"
    :try_start_1
    invoke-interface {v3}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 184
    .local v2, "value":Ljava/lang/Object;, "TV;"
    :try_start_2
    iget-object v4, p0, La/b/c/f/i;->a:Ljava/util/LinkedHashMap;

    invoke-virtual {v4, v1}, Ljava/util/LinkedHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 185
    iget v4, p0, La/b/c/f/i;->b:I

    invoke-direct {p0, v1, v2}, La/b/c/f/i;->c(Ljava/lang/Object;Ljava/lang/Object;)I

    move-result v5

    sub-int/2addr v4, v5

    iput v4, p0, La/b/c/f/i;->b:I

    .line 186
    iget v4, p0, La/b/c/f/i;->f:I

    const/4 v5, 0x1

    add-int/2addr v4, v5

    iput v4, p0, La/b/c/f/i;->f:I

    .line 187
    .end local v3    # "toEvict":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<TK;TV;>;"
    monitor-exit p0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    .line 189
    invoke-virtual {p0, v5, v1, v2, v0}, La/b/c/f/i;->a(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 190
    .end local v1    # "key":Ljava/lang/Object;, "TK;"
    .end local v2    # "value":Ljava/lang/Object;, "TV;"
    goto :goto_0

    .line 187
    .restart local v1    # "key":Ljava/lang/Object;, "TK;"
    :catchall_0
    move-exception v0

    goto :goto_2

    .line 178
    .end local v1    # "key":Ljava/lang/Object;, "TK;"
    :cond_2
    :goto_1
    :try_start_3
    monitor-exit p0

    .line 191
    return-void

    .line 173
    :cond_3
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v4, ".sizeOf() is reporting inconsistent results!"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .end local p1    # "maxSize":I
    throw v0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 187
    .restart local p1    # "maxSize":I
    :catchall_1
    move-exception v0

    .restart local v1    # "key":Ljava/lang/Object;, "TK;"
    .restart local v2    # "value":Ljava/lang/Object;, "TV;"
    :goto_2
    :try_start_4
    monitor-exit p0
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    throw v0

    :catchall_2
    move-exception v0

    goto :goto_2
.end method

.method protected a(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 0
    .param p1, "evicted"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(ZTK;TV;TV;)V"
        }
    .end annotation

    .line 236
    .local p0, "this":La/b/c/f/i;, "Landroid/support/v4/util/LruCache<TK;TV;>;"
    .local p2, "key":Ljava/lang/Object;, "TK;"
    .local p3, "oldValue":Ljava/lang/Object;, "TV;"
    .local p4, "newValue":Ljava/lang/Object;, "TV;"
    return-void
.end method

.method protected b(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;TV;)I"
        }
    .end annotation

    .line 274
    .local p0, "this":La/b/c/f/i;, "Landroid/support/v4/util/LruCache<TK;TV;>;"
    .local p1, "key":Ljava/lang/Object;, "TK;"
    .local p2, "value":Ljava/lang/Object;, "TV;"
    const/4 v0, 0x1

    return v0
.end method

.method public final b(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;)TV;"
        }
    .end annotation

    .line 83
    .local p0, "this":La/b/c/f/i;, "Landroid/support/v4/util/LruCache<TK;TV;>;"
    .local p1, "key":Ljava/lang/Object;, "TK;"
    if-eqz p1, :cond_4

    .line 88
    monitor-enter p0

    .line 89
    const/4 v0, 0x0

    :try_start_0
    iget-object v1, p0, La/b/c/f/i;->a:Ljava/util/LinkedHashMap;

    invoke-virtual {v1, p1}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 90
    .local v1, "mapValue":Ljava/lang/Object;, "TV;"
    if-eqz v1, :cond_0

    .line 91
    :try_start_1
    iget v0, p0, La/b/c/f/i;->g:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, La/b/c/f/i;->g:I

    .line 92
    monitor-exit p0

    return-object v1

    .line 94
    :cond_0
    iget v2, p0, La/b/c/f/i;->h:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, La/b/c/f/i;->h:I

    .line 95
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_2

    .line 104
    invoke-virtual {p0, p1}, La/b/c/f/i;->a(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 105
    .local v2, "createdValue":Ljava/lang/Object;, "TV;"
    if-nez v2, :cond_1

    .line 106
    return-object v0

    .line 109
    :cond_1
    monitor-enter p0

    .line 110
    :try_start_2
    iget v0, p0, La/b/c/f/i;->e:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, La/b/c/f/i;->e:I

    .line 111
    iget-object v0, p0, La/b/c/f/i;->a:Ljava/util/LinkedHashMap;

    invoke-virtual {v0, p1, v2}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    move-object v1, v0

    .line 113
    if-eqz v1, :cond_2

    .line 115
    iget-object v0, p0, La/b/c/f/i;->a:Ljava/util/LinkedHashMap;

    invoke-virtual {v0, p1, v1}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 117
    :cond_2
    iget v0, p0, La/b/c/f/i;->b:I

    invoke-direct {p0, p1, v2}, La/b/c/f/i;->c(Ljava/lang/Object;Ljava/lang/Object;)I

    move-result v3

    add-int/2addr v0, v3

    iput v0, p0, La/b/c/f/i;->b:I

    .line 119
    :goto_0
    monitor-exit p0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 121
    if-eqz v1, :cond_3

    .line 122
    const/4 v0, 0x0

    invoke-virtual {p0, v0, p1, v2, v1}, La/b/c/f/i;->a(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 123
    return-object v1

    .line 125
    :cond_3
    iget v0, p0, La/b/c/f/i;->c:I

    invoke-virtual {p0, v0}, La/b/c/f/i;->a(I)V

    .line 126
    return-object v2

    .line 119
    :catchall_0
    move-exception v0

    :try_start_3
    monitor-exit p0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    throw v0

    .line 95
    .end local v1    # "mapValue":Ljava/lang/Object;, "TV;"
    .end local v2    # "createdValue":Ljava/lang/Object;, "TV;"
    :catchall_1
    move-exception v1

    move-object v4, v1

    move-object v1, v0

    move-object v0, v4

    .restart local v1    # "mapValue":Ljava/lang/Object;, "TV;"
    :goto_1
    :try_start_4
    monitor-exit p0
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    throw v0

    :catchall_2
    move-exception v0

    goto :goto_1

    .line 84
    .end local v1    # "mapValue":Ljava/lang/Object;, "TV;"
    :cond_4
    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "key == null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    goto :goto_3

    :goto_2
    throw v0

    :goto_3
    goto :goto_2
.end method

.method public final declared-synchronized toString()Ljava/lang/String;
    .locals 7

    .local p0, "this":La/b/c/f/i;, "Landroid/support/v4/util/LruCache<TK;TV;>;"
    monitor-enter p0

    .line 348
    :try_start_0
    iget v0, p0, La/b/c/f/i;->g:I

    iget v1, p0, La/b/c/f/i;->h:I

    add-int/2addr v0, v1

    .line 349
    .local v0, "accesses":I
    const/4 v1, 0x0

    if-eqz v0, :cond_0

    iget v2, p0, La/b/c/f/i;->g:I

    mul-int/lit8 v2, v2, 0x64

    div-int/2addr v2, v0

    goto :goto_0

    .end local p0    # "this":La/b/c/f/i;, "Landroid/support/v4/util/LruCache<TK;TV;>;"
    :cond_0
    const/4 v2, 0x0

    .line 350
    .local v2, "hitPercent":I
    :goto_0
    sget-object v3, Ljava/util/Locale;->US:Ljava/util/Locale;

    const-string v4, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]"

    const/4 v5, 0x4

    new-array v5, v5, [Ljava/lang/Object;

    iget v6, p0, La/b/c/f/i;->c:I

    .line 351
    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v5, v1

    const/4 v1, 0x1

    iget v6, p0, La/b/c/f/i;->g:I

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v5, v1

    const/4 v1, 0x2

    iget v6, p0, La/b/c/f/i;->h:I

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v5, v1

    const/4 v1, 0x3

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v5, v1

    .line 350
    invoke-static {v3, v4, v5}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v1

    .line 347
    .end local v0    # "accesses":I
    .end local v2    # "hitPercent":I
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
