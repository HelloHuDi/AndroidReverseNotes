.class La/b/d/c/a/b$a;
.super La/b/d/c/a/b$f;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = La/b/d/c/a/b;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "a"
.end annotation


# instance fields
.field private final a:Landroid/graphics/drawable/Animatable;


# direct methods
.method constructor <init>(Landroid/graphics/drawable/Animatable;)V
    .locals 1
    .param p1, "a"    # Landroid/graphics/drawable/Animatable;

    .line 369
    const/4 v0, 0x0

    invoke-direct {p0, v0}, La/b/d/c/a/b$f;-><init>(La/b/d/c/a/a;)V

    .line 370
    iput-object p1, p0, La/b/d/c/a/b$a;->a:Landroid/graphics/drawable/Animatable;

    .line 371
    return-void
.end method


# virtual methods
.method public c()V
    .locals 1

    .line 375
    iget-object v0, p0, La/b/d/c/a/b$a;->a:Landroid/graphics/drawable/Animatable;

    invoke-interface {v0}, Landroid/graphics/drawable/Animatable;->start()V

    .line 376
    return-void
.end method

.method public d()V
    .locals 1

    .line 380
    iget-object v0, p0, La/b/d/c/a/b$a;->a:Landroid/graphics/drawable/Animatable;

    invoke-interface {v0}, Landroid/graphics/drawable/Animatable;->stop()V

    .line 381
    return-void
.end method
