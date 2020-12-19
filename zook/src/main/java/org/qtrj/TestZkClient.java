package org.qtrj;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

public class TestZkClient {

    public static void main(String[] args) throws Exception {
        ZooKeeper zk = new ZooKeeper("zoo1:2181,zoo2:2182,zoo3:2183", 30000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println(event.getState());
                System.out.println(event.getType());
                System.out.println(event.getPath());
                System.out.println("--------------------");
            }
        });

        // zk.create("/myGirls22", "absssc".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
        // CreateMode.PERSISTENT);

        zk.create("/myGirls22", "absssc".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);

        byte[] ss = zk.getData("/myGirls22", true, null);
        System.out.println(new String(ss));
        zk.setData("/myGirls22", "22222".getBytes(), -1);
        zk.setData("/myGirls22", "33333".getBytes(), -1);//

        ss = zk.getData("/myGirls22", true, null);
        System.out.println(new String(ss));
        // zk.delete("/myGirls22", -1);
        zk.close();
    }
}
