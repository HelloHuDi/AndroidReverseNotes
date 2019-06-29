.class La/a/a/b/c$a;
.super La/a/a/b/c$e;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = La/a/a/b/c;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "a"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<K:",
        "Ljava/lang/Object;",
        "V:",
        "Ljava/lang/Object;",
        ">",
        "La/a/a/b/c$e<",
        "TK;TV;>;"
    }
.end annotation


# direct methods
.method constructor <init>(La/a/a/b/c$c;La/a/a/b/c$c;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La/a/a/b/c$c<",
            "TK;TV;>;",
            "La/a/a/b/c$c<",
            "TK;TV;>;)V"
        }
    .end annotation

    .line 270
    .local p0, "this":La/a/a/b/c$a;, "Landroid/arch/core/internal/SafeIterableMap$AscendingIterator<TK;TV;>;"
    .local p1, "start":La/a/a/b/c$c;, "Landroid/arch/core/internal/SafeIterableMap$Entry<TK;TV;>;"
    .local p2, "expectedEnd":La/a/a/b/c$c;, "Landroid/arch/core/internal/SafeIterableMap$Entry<TK;TV;>;"
    invoke-direct {p0, p1, p2}, La/a/a/b/c$e;-><init>(La/a/a/b/c$c;La/a/a/b/c$c;)V

    .line 271
    return-void
.end method


# virtual methods
.method b(La/a/a/b/c$c;)La/a/a/b/c$c;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La/a/a/b/c$c<",
            "TK;TV;>;)",
            "La/a/a/b/c$c<",
            "TK;TV;>;"
        }
    .end annotation

    .line 280
    .local p0, "this":La/a/a/b/c$a;, "Landroid/arch/core/internal/SafeIterableMap$AscendingIterator<TK;TV;>;"
    .local p1, "entry":La/a/a/b/c$c;, "Landroid/arch/core/internal/SafeIterableMap$Entry<TK;TV;>;"
    iget-object v0, p1, La/a/a/b/c$c;->d:La/a/a/b/c$c;

    return-object v0
.end method

.method c(La/a/a/b/c$c;)La/a/a/b/c$c;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La/a/a/b/c$c<",
            "TK;TV;>;)",
            "La/a/a/b/c$c<",
            "TK;TV;>;"
        }
    .end annotation

    .line 275
    .local p0, "this":La/a/a/b/c$a;, "Landroid/arch/core/internal/SafeIterableMap$AscendingIterator<TK;TV;>;"
    .local p1, "entry":La/a/a/b/c$c;, "Landroid/arch/core/internal/SafeIterableMap$Entry<TK;TV;>;"
    iget-object v0, p1, La/a/a/b/c$c;->c:La/a/a/b/c$c;

    return-object v0
.end method
