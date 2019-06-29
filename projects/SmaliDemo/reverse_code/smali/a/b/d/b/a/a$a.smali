.class La/b/d/b/a/a$a;
.super Ljava/lang/Object;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = La/b/d/b/a/a;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "a"
.end annotation


# instance fields
.field final a:Landroid/content/res/ColorStateList;

.field final b:Landroid/content/res/Configuration;


# direct methods
.method constructor <init>(Landroid/content/res/ColorStateList;Landroid/content/res/Configuration;)V
    .locals 0
    .param p1, "value"    # Landroid/content/res/ColorStateList;
    .param p2, "configuration"    # Landroid/content/res/Configuration;

    .line 184
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 185
    iput-object p1, p0, La/b/d/b/a/a$a;->a:Landroid/content/res/ColorStateList;

    .line 186
    iput-object p2, p0, La/b/d/b/a/a$a;->b:Landroid/content/res/Configuration;

    .line 187
    return-void
.end method
