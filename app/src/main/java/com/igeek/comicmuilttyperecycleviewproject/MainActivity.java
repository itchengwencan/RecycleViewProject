package com.igeek.comicmuilttyperecycleviewproject;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.igeek.hfrecyleviewlib.BasicRecyViewHolder;
import com.igeek.hfrecyleviewlib.HFGridMultiTypeGapDecoration;
import com.igeek.hfrecyleviewlib.HFMultiTypeRecyAdapter;
import com.igeek.hfrecyleviewlib.HolderTypeData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import adapter.HFGridMuiltTypeSpanSizeLookup;
import bean.RmListType1;
import bean.RmListType2;
import bean.RmListType3;
import bean.RmListType4;
import bean.RmListType5;
import bean.RmListType6;
import bean.RmListType7;
import entitys.RmTypeData1;
import entitys.RmTypeData2;
import entitys.RmTypeData3;
import entitys.RmTypeData4;
import entitys.RmTypeData5;
import entitys.RmTypeData6;
import entitys.RmTypeData7;


public class MainActivity extends Activity implements
        BasicRecyViewHolder.OnItemClickListener{

    RecyclerView recyclerView;
    HFMultiTypeRecyAdapter adapter;

    View topView;
    View buttomView;

    public static final int type1=100;
    public static final int type2=101;
    public static final int type3=102;
    public static final int type4=103;
    public static final int type5=104;
    public static final int type6=105;
    public static final int type7=106;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        topView = getLayoutInflater().inflate(R.layout.layout_recommend_topview, null);
        buttomView = getLayoutInflater().inflate(R.layout.layout_recommend_buttomview, null);
        if (adapter == null) {
            adapter = new HFMultiTypeRecyAdapter();
            //添加头部
            adapter.setHeadView(topView);
            adapter.setFootView(buttomView);
            //添加item的点击事件
            adapter.setItemClickListener(this);
            adapter.addSubViewListener(R.id.rmTypeView1_more,moreListener);
            adapter.addSubViewListener(R.id.rmTypeView5_bigCoverImg,view5_bigCoverImgListener);
            adapter.addSubViewListener(R.id.rmTypeView5_smailCoverImg1,view5_coverImg1Listener);
            adapter.addSubViewListener(R.id.rmTypeView5_smailCoverImg2,view5_coverImg2Listener);
            adapter.addSubViewListener(R.id.rmTypeView5_smailCoverImg3,view5_coverImg3Listener);
            adapter.addFootSubViewListener(R.id.rmButtomView_img,buttomImgListener);
        }
        recyclerView.setAdapter(adapter);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        HFGridMuiltTypeSpanSizeLookup spanSizeLookup=new HFGridMuiltTypeSpanSizeLookup();
        spanSizeLookup.setAdapter(adapter);
        spanSizeLookup.setLayoutManager(gridLayoutManager);
        gridLayoutManager.setSpanSizeLookup(spanSizeLookup);
        recyclerView.setLayoutManager(gridLayoutManager);
        HFGridMultiTypeGapDecoration gapDecoration=new HFGridMultiTypeGapDecoration(8);
        gapDecoration.setOffsetTopEnabled(false);
        recyclerView.addItemDecoration(gapDecoration);
        handler.sendEmptyMessageDelayed(0,1000);
    }

    /**
     * 处理用户点击推荐列表当中的【更多】按钮
     */
    public void handleMoreClickEventToDetailPage(RmListType1 typeData){
        Toast.makeText(MainActivity.this,"【"+typeData.getData().getTitle()+"】更多",Toast.LENGTH_SHORT).show();
        //需要根据一个特定的值来区分代表了哪个区域的操作
    }

    @Override
    public void OnItemClick(View v, int adapterPosition) {
        HolderTypeData typeData=adapter.getData(adapter.getPositon(adapterPosition));
        switch (typeData.getType()){
            case type1:
                break;
            case type2:
                handleFullScrrenAdImgClickEvent();
                break;
            case type3:
                break;
            case type4:
                break;
            case type5:
                break;
            case type6:
                break;
            case type7:
                break;
        }
        Toast.makeText(this,"position="+adapter.getPositon(adapterPosition),Toast.LENGTH_SHORT).show();
    }

    /**
     * 处理占据一行的广告图片的点击事件
     */
    public void handleFullScrrenAdImgClickEvent(){

    }

    android.os.Handler handler=new android.os.Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            adapter.refreshDatas(buildDemoList());
        }
    };

    public List<HolderTypeData> buildDemoList() {
        List<HolderTypeData> datas = new ArrayList<HolderTypeData>();

        //人气推荐
        RmListType1 commend_type1=new RmListType1();
        RmTypeData1 commendTitleData=new RmTypeData1(type1,"人气推荐");
        commend_type1.setData(commendTitleData);
        datas.add(commend_type1);

        RmListType4 commend_type4_1=new RmListType4();
        RmTypeData4 commend_type4_1data=new RmTypeData4(type4,"鬼抬轿");
        commend_type4_1data.setCoverImgId(R.mipmap.ic_grid_img);
        commend_type4_1data.setHotNumber(new Random().nextInt(10000));
        commend_type4_1data.setNewstChapter(new Random().nextInt(400));

        commend_type4_1.setData(commend_type4_1data);

        RmListType4 commend_type4_2=new RmListType4();
        RmTypeData4 commend_type4_2data=new RmTypeData4(type4,"牛油果沙拉");
        commend_type4_2data.setCoverImgId(R.mipmap.ic_grid_img);
        commend_type4_2data.setHotNumber(new Random().nextInt(10000));
        commend_type4_2data.setNewstChapter(new Random().nextInt(400));

        commend_type4_2.setData(commend_type4_2data);

        RmListType4 commend_type4_3=new RmListType4();
        RmTypeData4 commend_type4_3data=new RmTypeData4(type4,"愚蠢的人类快放郑走");
        commend_type4_3data.setCoverImgId(R.mipmap.ic_grid_img);
        commend_type4_3data.setHotNumber(new Random().nextInt(10000));
        commend_type4_3data.setNewstChapter(new Random().nextInt(400));

        commend_type4_3.setData(commend_type4_3data);

        RmListType4 commend_type4_4=new RmListType4();
        RmTypeData4 commend_type4_4data=new RmTypeData4(type4,"猫恋");
        commend_type4_4data.setCoverImgId(R.mipmap.ic_grid_img);
        commend_type4_4data.setHotNumber(new Random().nextInt(10000));
        commend_type4_4data.setNewstChapter(new Random().nextInt(400));

        commend_type4_4.setData(commend_type4_4data);

        datas.add(commend_type4_1);
        datas.add(commend_type4_2);
        datas.add(commend_type4_3);
        datas.add(commend_type4_4);

        //原创独家
        RmListType1 originalData=new RmListType1();
        RmTypeData1 originalData1=new RmTypeData1(type1,"原创独家");
        originalData.setData(originalData1);
        datas.add(originalData);

        RmListType5 original_type5=new RmListType5();
        RmTypeData5 original_type5data=new RmTypeData5(type5,"");
        original_type5.setData(original_type5data);
        datas.add(original_type5);

        //官方活动
        RmListType1 officialData=new RmListType1();
        RmTypeData1 officialData1=new RmTypeData1(type1,"官方活动");
        officialData.setData(officialData1);
        datas.add(officialData);

        RmListType6 officialData_type6=new RmListType6();
        RmTypeData6 officialData_type6data=new RmTypeData6(type6);
        officialData_type6data.setCoverImgIds(buildResIdLists());
        officialData_type6.setData(officialData_type6data);
        datas.add(officialData_type6);

        //一周热门活动
        RmListType1 aweekData=new RmListType1();
        RmTypeData1 aweekData1=new RmTypeData1(type1,"一周热门活动");
        aweekData.setData(aweekData1);
        datas.add(aweekData);

        RmListType3 aweekData_type3_1= new RmListType3();
        RmTypeData3 aweekData_type3_1data= new RmTypeData3(type3);
        aweekData_type3_1.setData(aweekData_type3_1data);

        RmListType3 aweekData_type3_2= new RmListType3();
        RmTypeData3 aweekData_type3_2data= new RmTypeData3(type3);
        aweekData_type3_2.setData(aweekData_type3_2data);
        RmListType3 aweekData_type3_3= new RmListType3();
        RmTypeData3 aweekData_type3_3data= new RmTypeData3(type3);
        aweekData_type3_3.setData(aweekData_type3_3data);

        RmListType3 aweekData_type3_4= new RmListType3();
        RmTypeData3 aweekData_type3_4data= new RmTypeData3(type3);
        aweekData_type3_4.setData(aweekData_type3_4data);

        datas.add(aweekData_type3_1);
        datas.add(aweekData_type3_2);
        datas.add(aweekData_type3_3);
        datas.add(aweekData_type3_4);

        RmListType2 data2_1=new RmListType2();
        RmTypeData2 data2_1data=new RmTypeData2(type2);
        data2_1.setData(data2_1data);
        datas.add(data2_1);

        //精品书单
        RmListType1 boutiqueData=new RmListType1();
        RmTypeData1 boutiqueData1=new RmTypeData1(type1,"精品书单");
        boutiqueData.setData(boutiqueData1);
        datas.add(boutiqueData);

        RmListType7 boutique_type7_1=new RmListType7();
        RmTypeData7 boutique_type7_1data=new RmTypeData7(type7,"金龙奖获奖名单");
        boutique_type7_1data.setCoverImgId(R.mipmap.ic_grid_img);
        boutique_type7_1data.setHotNumber(new Random().nextInt(10000));
        boutique_type7_1.setData(boutique_type7_1data);

        RmListType7 boutique_type7_2=new RmListType7();
        RmTypeData7 boutique_type7_2data=new RmTypeData7(type7,"漫友合集");
        boutique_type7_2data.setCoverImgId(R.mipmap.ic_grid_img);
        boutique_type7_2data.setHotNumber(new Random().nextInt(10000));
        boutique_type7_2.setData(boutique_type7_2data);

        RmListType7 boutique_type7_3=new RmListType7();
        RmTypeData7 boutique_type7_3data=new RmTypeData7(type7,"另类画风漫画");
        boutique_type7_3data.setCoverImgId(R.mipmap.ic_grid_img);
        boutique_type7_3data.setHotNumber(new Random().nextInt(10000));
        boutique_type7_3.setData(boutique_type7_3data);

        RmListType7 boutique_type7_4=new RmListType7();
        RmTypeData7 boutique_type7_4data=new RmTypeData7(type7,"猫恋");
        boutique_type7_4data.setCoverImgId(R.mipmap.ic_grid_img);
        boutique_type7_4data.setHotNumber(new Random().nextInt(10000));
        boutique_type7_4.setData(boutique_type7_4data);

        datas.add(boutique_type7_1);
        datas.add(boutique_type7_2);
        datas.add(boutique_type7_3);
        datas.add(boutique_type7_4);

        //热播动画
        RmListType1 hotPlayData=new RmListType1();
        RmTypeData1 hotPlayData1=new RmTypeData1(type1,"热播动画");
        hotPlayData.setData(hotPlayData1);
        datas.add(hotPlayData);

        RmListType7 hotPlay_type4_1=new RmListType7();
        RmTypeData7 hotPlay_type4_1data=new RmTypeData7(type7,"Charlotte ");
        hotPlay_type4_1data.setSubTitle("sub title dec");
        hotPlay_type4_1data.setCoverImgId(R.mipmap.ic_grid_img);
        hotPlay_type4_1data.setHotNumber(new Random().nextInt(10000));
        hotPlay_type4_1.setData(hotPlay_type4_1data);

        RmListType7 hotPlay_type4_2=new RmListType7();
        RmTypeData7 hotPlay_type4_2data=new RmTypeData7(type7,"十万个冷笑话");
        hotPlay_type4_2data.setSubTitle("sub title dec");
        hotPlay_type4_2data.setCoverImgId(R.mipmap.ic_grid_img);
        hotPlay_type4_2data.setHotNumber(new Random().nextInt(10000));
        hotPlay_type4_2.setData(hotPlay_type4_2data);

        RmListType7 hotPlay_type4_3=new RmListType7();
        RmTypeData7 hotPlay_type4_3data=new RmTypeData7(type7,"干物妹小狸哈哈哈哈哈哈hha");
        hotPlay_type4_3data.setSubTitle("sub title dec");
        hotPlay_type4_3data.setCoverImgId(R.mipmap.ic_grid_img);
        hotPlay_type4_3data.setHotNumber(new Random().nextInt(10000));
        hotPlay_type4_3.setData(hotPlay_type4_3data);

        RmListType7 hotPlay_type4_4=new RmListType7();
        RmTypeData7 hotPlay_type4_4data=new RmTypeData7(type7,"中国惊奇先生");
        hotPlay_type4_4data.setSubTitle("sub title dec");
        hotPlay_type4_4data.setCoverImgId(R.mipmap.ic_grid_img);
        hotPlay_type4_4data.setHotNumber(new Random().nextInt(10000));
        hotPlay_type4_4.setData(hotPlay_type4_4data);

        datas.add(hotPlay_type4_1);
        datas.add(hotPlay_type4_2);
        datas.add(hotPlay_type4_3);
        datas.add(hotPlay_type4_4);

        return datas;
    }

    public List<Integer> buildResIdLists(){
        List<Integer> resIds=new ArrayList<Integer>();
        for(int index=0;index<4;index++){
            resIds.add(R.mipmap.ic_grid_img);
        }
        return resIds;
    }

    View.OnClickListener moreListener=new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            int postion=(int) view.getTag();
            int type=  adapter.getData(postion).getType();
            if( type==type1){
                handleMoreClickEventToDetailPage((RmListType1) adapter.getData(postion));
            }
        }
    };

    View.OnClickListener view5_bigCoverImgListener=new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this,"原创独家的大图片广告",Toast.LENGTH_SHORT).show();
        }
    };

    View.OnClickListener view5_coverImg1Listener=new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this,"原创独家的第一张小图片广告",Toast.LENGTH_SHORT).show();
        }
    };

    View.OnClickListener view5_coverImg2Listener=new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this,"原创独家的第二张小图片广告",Toast.LENGTH_SHORT).show();
        }
    };

    View.OnClickListener view5_coverImg3Listener=new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this,"原创独家的第三张小图片广告",Toast.LENGTH_SHORT).show();
        }
    };

    View.OnClickListener buttomImgListener=new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this,"推荐列表底部的广告图片",Toast.LENGTH_SHORT).show();
        }
    };
}
