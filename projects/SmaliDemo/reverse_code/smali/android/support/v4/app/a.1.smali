.class public Landroid/support/v4/app/a;
.super La/b/c/a/a;
.source ""


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/v4/app/a$c;,
        Landroid/support/v4/app/a$b;,
        Landroid/support/v4/app/a$a;
    }
.end annotation


# static fields
.field private static c:Landroid/support/v4/app/a$b;


# direct methods
.method public static a()Landroid/support/v4/app/a$b;
    .locals 1

    .line 169
    sget-object v0, Landroid/support/v4/app/a;->c:Landroid/support/v4/app/a$b;

    return-object v0
.end method

.method public static a(Landroid/app/Activity;)V
    .locals 2
    .param p0, "activity"    # Landroid/app/Activity;

    .line 287
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x10

    if-lt v0, v1, :cond_0

    .line 288
    invoke-virtual {p0}, Landroid/app/Activity;->finishAffinity()V

    goto :goto_0

    .line 290
    :cond_0
    invoke-virtual {p0}, Landroid/app/Activity;->finish()V

    .line 292
    :goto_0
    return-void
.end method
