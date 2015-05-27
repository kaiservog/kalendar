package kalendar.com.kalendar.map;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import kalendar.com.kalendar.R;

/**
 * Created by César on 21/05/2015.
 */
public class PlaceHolderMap extends Fragment implements OnMapReadyCallback {

    private GoogleMapOptions options;
    private View mapView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        if(mapView != null) return mapView;

        Log.d("kaiservog", "passou pelo map holder");
        mapView = inflater.inflate(R.layout.activity_map, container, false);

        SupportMapFragment mapFragment = ((SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map));
        mapFragment.getMapAsync(this);

        return mapView;
    }

    @Override
    public void onMapReady(GoogleMap map) {
        map.addMarker(new MarkerOptions()
                .position(new LatLng(-23.568341, -46.649488))
                .title("Marker"));

        CameraPosition conf = CameraPosition.builder().target(new LatLng(-23.568341, -46.649488)).zoom(20).build();
                
        map.animateCamera(CameraUpdateFactory.newCameraPosition(conf));
    }

}
