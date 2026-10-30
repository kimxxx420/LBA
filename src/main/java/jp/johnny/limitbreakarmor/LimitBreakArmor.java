Run gradle --no-daemon build
To honour the JVM settings for this build a single-use Daemon process will be forked. For more on this, please refer to https://docs.gradle.org/8.10.2/userguide/gradle_daemon.html#sec:disabling_the_daemon in the Gradle documentation.
Daemon will be stopped at the end of the build 

> Task :createMinecraftArtifacts
Loaded 111 artifacts from /home/runner/work/LBA/LBA/build/tmp/createMinecraftArtifacts/nfrt_artifact_manifest.properties
*** Started working on downloadJson
 ✓ Completed downloadJson in 0.02s
*** Started working on downloadClientMappings
*** Started working on downloadServer
*** Started working on downloadClient
*** Started working on listLibraries
 ♻ Used cache of listLibraries in 0.00s
 ✓ Completed downloadClient in 0.04s
 ✓ Completed downloadClientMappings in 0.04s
 ✓ Completed downloadServer in 0.04s
*** Started working on mergeMappings
 ♻ Used cache of mergeMappings in 0.00s
*** Started working on stripClient
 ♻ Used cache of stripClient in 0.00s
*** Started working on extractServer
 ♻ Used cache of extractServer in 0.00s
*** Started working on stripServer
 ♻ Used cache of stripServer in 0.00s
*** Started working on merge
 ♻ Used cache of merge in 0.00s
*** Started working on rename
 ♻ Used cache of rename in 0.00s
*** Started working on decompile
 ♻ Used cache of decompile in 0.00s
*** Started working on inject
 ♻ Used cache of inject in 0.00s
*** Started working on patch
 ♻ Used cache of patch in 0.00s
*** Started working on applyNeoforgePatches
 ♻ Used cache of applyNeoforgePatches in 0.00s
*** Started working on transformSources
 ♻ Used cache of transformSources in 0.00s
*** Started working on recompile
 ♻ Used cache of recompile in 0.00s
*** Started working on sourcesWithNeoForge
 ♻ Used cache of sourcesWithNeoForge in 0.00s
*** Started working on compiledWithNeoForge
 ♻ Used cache of compiledWithNeoForge in 0.00s
*** Started working on sourcesAndCompiledWithNeoForge
 ♻ Used cache of sourcesAndCompiledWithNeoForge in 0.00s
Total runtime: 1.08s


/home/runner/work/LBA/LBA/src/main/java/jp/johnny/limitbreakarmor/LimitBreakArmor.java:6: error: class, interface, enum, or record expected
> Task :compileJava FAILED
gradle/actions: Writing build results to /home/runner/work/_temp/.gradle-actions/build-results/__run-1793359986081.json
2 actionable tasks: 2 executed
import net.neoforged.fml.common.EventBusSubscriber;package jp.johnny.limitbreakarmor;
                                                   ^
/home/runner/work/LBA/LBA/src/main/java/jp/johnny/limitbreakarmor/LimitBreakArmor.java:8: error: class, interface, enum, or record expected
import net.minecraft.world.entity.ai.attributes.Attributes;
^
/home/runner/work/LBA/LBA/src/main/java/jp/johnny/limitbreakarmor/LimitBreakArmor.java:9: error: class, interface, enum, or record expected
import net.minecraft.world.entity.player.Player;
^
/home/runner/work/LBA/LBA/src/main/java/jp/johnny/limitbreakarmor/LimitBreakArmor.java:10: error: class, interface, enum, or record expected
import net.neoforged.bus.api.SubscribeEvent;
^
/home/runner/work/LBA/LBA/src/main/java/jp/johnny/limitbreakarmor/LimitBreakArmor.java:11: error: class, interface, enum, or record expected
import net.neoforged.fml.common.EventBusSubscriber;
^
/home/runner/work/LBA/LBA/src/main/java/jp/johnny/limitbreakarmor/LimitBreakArmor.java:12: error: class, interface, enum, or record expected
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
^
/home/runner/work/LBA/LBA/src/main/java/jp/johnny/limitbreakarmor/LimitBreakArmor.java:45: error: class, interface, enum, or record expected
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
^
7 errors

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':compileJava'.
> Compilation failed; see the compiler error output for details.

* Try:
> Run with --info option to get more log output.
> Run with --scan to get full insights.

BUILD FAILED in 10s
Error: Process completed with exit code 1.
