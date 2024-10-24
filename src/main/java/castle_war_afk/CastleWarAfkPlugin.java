package castle_war_afk;

import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.Notifier;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.events.WidgetClosed;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
	name = "Castle War AFK"
)
public class CastleWarAfkPlugin extends Plugin
{

	@Inject
	private Notifier notifier;
	

	@Override
	protected void startUp() throws Exception
	{
		log.info("Castle War AFK started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("Castle War AFK stopped!");
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		if (event.getGroupId() != 59 &&  event.getGroupId() != 58){
			return;
		}
		
		notifier.notify("Castle War: Leave the room to go AFK");
	}

	@Subscribe
	public void onWidgetClosed(WidgetClosed event)
	{
		if (event.getGroupId() != 59 &&  event.getGroupId() != 58){
			return;
		}
		
		notifier.notify("Castle War Minigame Completed!");
	}
}
