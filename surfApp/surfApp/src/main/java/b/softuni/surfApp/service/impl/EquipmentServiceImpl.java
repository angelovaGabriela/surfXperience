package b.softuni.surfApp.service.impl;


import b.softuni.surfApp.repository.EquipmentTypeRepository;
import b.softuni.surfApp.service.EquipmentService;
import org.springframework.stereotype.Service;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    private final EquipmentTypeRepository typeRepository;

    public EquipmentServiceImpl(EquipmentTypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }


}
