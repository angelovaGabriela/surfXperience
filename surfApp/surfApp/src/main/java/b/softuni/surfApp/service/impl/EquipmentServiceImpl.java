package b.softuni.surfApp.service.impl;

import b.softuni.surfApp.model.entity.CommentMood;
import b.softuni.surfApp.model.entity.EquipmentType;
import b.softuni.surfApp.model.enums.EquipmentTypeEnum;
import b.softuni.surfApp.repository.EquipmentTypeRepository;
import b.softuni.surfApp.service.EquipmentService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    private final EquipmentTypeRepository typeRepository;

    public EquipmentServiceImpl(EquipmentTypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public void initEquipmentTypes() {
        if (this.typeRepository.count() == 0) {
            Arrays.stream(EquipmentTypeEnum.values())
                    .forEach(type -> {
                        EquipmentType equipmentType = new EquipmentType();
                        equipmentType.setName(type);
                        this.typeRepository.save(equipmentType);
                    });
        }
    }
}
